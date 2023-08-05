package com.zerobase.fastlms.admin.controller;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminBannerController {

    private final BannerService bannerService;

    @PostMapping("/admin/banner/add.do")
    public String add(Model model, BannerInput parameter) {

        boolean result = bannerService.add(parameter);

        if (result) {
            return "redirect:/admin/banner/list.do";
        } else {
            model.addAttribute("errorMessage", "배너 추가에 실패했습니다.");
            return "admin/banner/add"; // 실패시 다시 추가 페이지로 이동
        }
    }

    @GetMapping("/admin/banner/list.do")
    public String list(Model model) {

        List<BannerDto> list = bannerService.list();
        model.addAttribute("list", list);

        return "admin/banner/list";
    }
}
