package com.xlyc.countychaincloudvillage.model.response;

import java.util.List;

public class FriendCircleListResponse {

    /**
     * pageCount : 2
     * pageList : [{"page":1,"rows":10,"type":"1","value":"\u201c\u201d","id":"1","custId":"\u201c\u201d","content":"21123123","videoUrl":"https://jingyan.baidu.com/article/cbf0e5004396002eaa28932c.html#5827690-tsina-1-16554-fe183374908e783f9dbfe7dcb7ed2bb5","imageUrl":"http://jingtongceshiqianbao.oss-cn-hangzhou.aliyuncs.com/20180913/e20c2c020fba45ad8ca8d45ba7ac5485.jpg","place":"安阳市林州","status":22,"createTime":1553398048000,"areaCode":"410505009","appId":"\u201c\u201d","userRegAreaName":"安阳市","busiType":1,"userPortrait":"http://jingtongceshiqianbao.oss-cn-hangzhou.aliyuncs.com/20180913/e20c2c020fba45ad8ca8d45ba7ac5485.jpg","userName":"张三","userScore":"100","sex":0,"dotpraiseStatus":1,"dotpraiseNum":1,"collectNum":0,"reviewNum":0,"transpondNum":0}]
     */

    private int pageCount;
    private List<PageListBean> pageList;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<PageListBean> getPageList() {
        return pageList;
    }

    public void setPageList(List<PageListBean> pageList) {
        this.pageList = pageList;
    }

    public static class PageListBean {
        /**
         * page : 1
         * rows : 10
         * type : 1
         * value : “”
         * id : 1
         * custId : “”
         * content : 21123123
         * videoUrl : https://jingyan.baidu.com/article/cbf0e5004396002eaa28932c.html#5827690-tsina-1-16554-fe183374908e783f9dbfe7dcb7ed2bb5
         * imageUrl : http://jingtongceshiqianbao.oss-cn-hangzhou.aliyuncs.com/20180913/e20c2c020fba45ad8ca8d45ba7ac5485.jpg
         * place : 安阳市林州
         * status : 22
         * createTime : 1553398048000
         * areaCode : 410505009
         * appId : “”
         * userRegAreaName : 安阳市
         * busiType : 1
         * userPortrait : http://jingtongceshiqianbao.oss-cn-hangzhou.aliyuncs.com/20180913/e20c2c020fba45ad8ca8d45ba7ac5485.jpg
         * userName : 张三
         * userScore : 100
         * sex : 0
         * dotpraiseStatus : 1
         * dotpraiseNum : 1
         * collectNum : 0
         * reviewNum : 0
         * transpondNum : 0
         */

        private int page;
        private int rows;
        private String type;
        private String value;
        private String id;
        private String custId;
        private String content;
        private String videoUrl;
        private String imageUrl;
        private String place;
        private int status;
        private long createTime;
        private String areaCode;
        private String appId;
        private String userRegAreaName;
        private int busiType;
        private String userPortrait;
        private String userName;
        private String userScore;
        private int sex;
        private int dotpraiseStatus;
        private int dotpraiseNum;
        private int collectNum;
        private int reviewNum;
        private int transpondNum;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCustId() {
            return custId;
        }

        public void setCustId(String custId) {
            this.custId = custId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getUserRegAreaName() {
            return userRegAreaName;
        }

        public void setUserRegAreaName(String userRegAreaName) {
            this.userRegAreaName = userRegAreaName;
        }

        public int getBusiType() {
            return busiType;
        }

        public void setBusiType(int busiType) {
            this.busiType = busiType;
        }

        public String getUserPortrait() {
            return userPortrait;
        }

        public void setUserPortrait(String userPortrait) {
            this.userPortrait = userPortrait;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserScore() {
            return userScore;
        }

        public void setUserScore(String userScore) {
            this.userScore = userScore;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getDotpraiseStatus() {
            return dotpraiseStatus;
        }

        public void setDotpraiseStatus(int dotpraiseStatus) {
            this.dotpraiseStatus = dotpraiseStatus;
        }

        public int getDotpraiseNum() {
            return dotpraiseNum;
        }

        public void setDotpraiseNum(int dotpraiseNum) {
            this.dotpraiseNum = dotpraiseNum;
        }

        public int getCollectNum() {
            return collectNum;
        }

        public void setCollectNum(int collectNum) {
            this.collectNum = collectNum;
        }

        public int getReviewNum() {
            return reviewNum;
        }

        public void setReviewNum(int reviewNum) {
            this.reviewNum = reviewNum;
        }

        public int getTranspondNum() {
            return transpondNum;
        }

        public void setTranspondNum(int transpondNum) {
            this.transpondNum = transpondNum;
        }
    }
}
