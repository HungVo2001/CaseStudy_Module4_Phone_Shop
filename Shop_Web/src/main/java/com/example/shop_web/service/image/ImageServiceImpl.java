package com.example.shop_web.service.image;

import com.example.shop_web.domain.Image;

import java.util.List;
import java.util.Optional;

public class ImageServiceImpl implements IImageService{
    @Override
    public List<Image> findAll() {
        return null;
    }

    @Override
    public Optional<Image> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Image image) {

    }

    @Override
    public void update(Image image) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
