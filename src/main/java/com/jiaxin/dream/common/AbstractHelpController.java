package com.jiaxin.dream.common;/**
 * @Author: bufoon
 * @Email: song.anling@zyxr.com
 * @Datetime: Created In 2018/4/25 9:49
 * @Desc: as follows.
 */

import com.jiaxin.dream.utils.IPUtil;
import com.jiaxin.dream.utils.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 抽象辅助类
 * @author: gongjiaxin
 * @create: 2018-04-25 9:49
 **/
public abstract class AbstractHelpController {
    /**
     * 验证接口调用白名单
     *
     * @param request
     * @throws Exception
     */
    @ModelAttribute
    public void verifyWhiteList(HttpServletRequest request) throws Exception {
//        String whiteListStr = ZKConstant.CALL_HELPCONTROLLER_WHITE_LIST.get();
        String whiteListStr = "127.0.0.1";
        if (StringUtils.isNotEmpty(whiteListStr)) {
            List<String> whiteList = Arrays.asList(whiteListStr.split(","));
            String ip = IPUtil.getIpAddr(request);
//            logger.info("客户端ip->>>>{}", ip);
            System.out.println("客户端ip->>>>" + ip);
            if (!whiteList.contains(ip)) {
                throw new Exception("非法请求");
            }
        }
    }
}
