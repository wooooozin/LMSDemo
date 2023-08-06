package com.zerobase.fastlms.admin.controller;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.admin.service.BannerService;
import com.zerobase.fastlms.course.controller.BaseController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminBannerController extends BaseController {

    private final BannerService bannerService;

    @GetMapping(value = {"/admin/banner/add.do", "/admin/banner/edit.do"})
    public String addOrEditBanner(Model model, HttpServletRequest request
            , BannerInput parameter) {

        boolean editMode = request.getRequestURI().contains("/edit.do");
        BannerDto detail = new BannerDto();

        if (editMode) {
            long id = parameter.getId();
            BannerDto existingBanner = bannerService.getById(id);
            if (existingBanner == null) {
                // error 처리
                model.addAttribute("message", "배너 정보가 존재하지 않습니다.");
                return "common/error";
            }
            detail = existingBanner;
        }

        model.addAttribute("editMode", editMode);
        model.addAttribute("detail", detail);

        return "admin/banner/add";
    }

    @PostMapping("/admin/banner/add.do")
    public String saveBanner(BannerInput bannerInput) {
        // 배너 정보 저장 또는 수정 로직
        boolean result = bannerService.saveOrUpdateBanner(bannerInput);
        if (result) {
            return "redirect:/admin/banner/list.do"; // 성공 시 목록 페이지로 리다이렉션
        } else {
            // 오류 처리
            return "common/error";
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
