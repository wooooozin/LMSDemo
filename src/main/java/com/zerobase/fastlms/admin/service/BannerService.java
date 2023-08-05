package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BannerService {

    private final BannerRepository bannerRepository;

    private Sort getSortBySortOrderDesc() {
        return Sort.by(Sort.Direction.DESC, "sortOrder");
    }

    public boolean add(BannerInput parameter) {
        MultipartFile imageFile = parameter.getImage();
        byte[] imageBytes = null;

        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                imageBytes = imageFile.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        Banner banner = Banner.builder()
                .image(imageBytes)
                .altText(parameter.getAltText())
                .url(parameter.getUrl())
                .target(parameter.getTarget())
                .sortOrder(parameter.getSortOrder())
                .displayYn(parameter.isDisplayYn())
                .build();

        bannerRepository.save(banner);
        return true;

    }

    public List<BannerDto> list() {
        List<Banner> banners = bannerRepository.findAll(getSortBySortOrderDesc());
        return BannerDto.of(banners);
    }
}
