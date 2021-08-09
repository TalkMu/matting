package com.koolss.www.matting.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RuntimeUtil;
import com.koolss.www.matting.constant.RembgConstant;
import com.koolss.www.matting.vo.ImageVO;
import com.koolss.www.matting.vo.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FileUploadController
 * @Description: 文件上传
 * @Author admin
 * @Date 2021/8/9 9:38
 * @Version 1.0.0
 * @Email koolss@koolss.com
 **/
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @RequestMapping("/img")
    public R img(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) {
        if (!FileUtil.exist(RembgConstant.INPUT_PATH)) {
            FileUtil.mkdir(RembgConstant.INPUT_PATH);
        }
        if (!FileUtil.exist(RembgConstant.OUTPUT_PATH)) {
            FileUtil.mkdir(RembgConstant.OUTPUT_PATH);
        }
        List<ImageVO> imageVOS = new ArrayList<ImageVO>();
        for (MultipartFile file : files) {
            // 上传的文件名称
            String originalFilename = file.getOriginalFilename();

            String newFileName = System.currentTimeMillis() + "." + FileUtil.getSuffix(originalFilename);
            String inputSavePath = RembgConstant.INPUT_PATH + newFileName;
            try {
                file.transferTo(new File(inputSavePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String outputSavePath = RembgConstant.OUTPUT_PATH + newFileName;
            String cmdStr = "rembg -o " + outputSavePath + " " + inputSavePath;
            RuntimeUtil.execForStr(cmdStr);
            String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
            String url = host + "/img/" + newFileName;
            File outFile = new File(outputSavePath);
            try {
                BufferedImage sourceImg = ImageIO.read(new FileInputStream(outFile));
                imageVOS.add(new ImageVO(originalFilename, FileUtil.readableFileSize(outFile), (sourceImg.getWidth() + "x" + sourceImg.getHeight()), url));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return R.data(imageVOS);
    }
}
