// Server-side JavaScript for the head.html logic
use(function () {
    var WCMUtils = Packages.com.day.cq.wcm.commons.WCMUtils;

    return {
        keywords: WCMUtils.getKeywords(currentPage, false)
    };
});