//package com.example.shop_web.service.image;
//
//import com.cloudinary.Cloudinary;
//import com.example.shop_web.domain.Image;
//import com.example.shop_web.repository.ImageRepository;
//import com.example.shop_web.util.UploadUtil;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@AllArgsConstructor
//@Service
//public class ImageService {
//
//    private final Cloudinary cloudinary;
//
//    private final ImageRepository imageRepository;
//
//    private final UploadUtil uploadUtil;
//
//    public Image saveAvatar(MultipartFile avatar) throws IOException {
//        var image = new Image();
//        imageRepository.save(image);
//
//        var uploadResult = cloudinary.uploader().upload(avatar.getBytes(), uploadUtil.buildImageUploadParams(image));
//
//        String fileUrl = (String) uploadResult.get("secure_url");
//        String fileFormat = (String) uploadResult.get("format");
//
//        image.setFileName(image.getId() + "." + fileFormat);
//        image.setFileUrl(fileUrl);
//        image.setFileFolder(UploadUtil.IMAGE_UPLOAD_FOLDER);
//        image.setCloudId(image.getFileFolder() + "/" + image.getId());
//        imageRepository.save(image);
//        return image;
//    }
//
//
//
//
//}
