package com.zerobase.fastlms.admin.controller;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.admin.service.BannerService;
import com.zerobase.fastlms.course.controller.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminBannerController extends BaseController {

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
    public String list(Model model, BannerParam bannerParam) {

        bannerParam.init(); // 파라미터 초기화
        List<BannerDto> bannerList = bannerService.list(bannerParam); // 배너 목록 가져오기

        long totalCount = 0;
        if (!CollectionUtils.isEmpty(bannerList)) {
            totalCount = bannerList.get(0).getTotalCount(); // 전체 배너 수 가져오기
        }
        String queryString = bannerParam.getQueryString(); // 쿼리 문자열 가져오기
        String pagerHtml = getPaperHtml(
                totalCount,
                bannerParam.getPageSize(),
                bannerParam.getPageIndex(),
                queryString
        );

        model.addAttribute("list", bannerList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pagerHtml);

        return "admin/banner/list";
    }
}
