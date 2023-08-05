package com.zerobase.fastlms.admin.controller;

import com.zerobase.fastlms.admin.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AdminBannerController {

    private final BannerService bannerService;


}
