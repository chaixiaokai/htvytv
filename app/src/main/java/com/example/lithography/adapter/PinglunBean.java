package com.example.lithography.adapter;

import java.util.List;

/**
 * Created by 柴晓凯 on 2018/1/3.
 */

public class PinglunBean {

    /**
     * code : 200
     * msg : 成功
     * ret : {"list":[{"dataId":"ff8080815c5dce45015c5e77b07c0675","likeNum":0,"msg":"超喜欢男神的这部片子，就是喜欢。","phoneNumber":"悲伤的恋曲","time":"2017-05-25 15:25:21","userPic":""},{"dataId":"ff8080815c5dce45015c5e77b0790673","likeNum":0,"msg":"没想到这个电影在手机电影APP里居然可以看到，赞一个。","phoneNumber":"伪装坚强","time":"2017-05-19 20:25:21","userPic":""},{"dataId":"ff8080815c5dce45015c5e77b0760672","likeNum":0,"msg":"呵呵，这种电影，不想评价更多！","phoneNumber":"忧别人之忧","time":"2017-05-18 11:25:21","userPic":""},{"dataId":"ff8080815c5dce45015c5e77b07b0674","likeNum":0,"msg":"这片子早就应该看了，幸好没有错过这么好的片子。","phoneNumber":"陌路丢了谁","time":"2017-05-15 19:25:21","userPic":""}],"pnum":1,"records":20,"totalPnum":1,"totalRecords":4}
     */

    private String code;
    private String msg;
    private RetBean ret;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RetBean getRet() {
        return ret;
    }

    public void setRet(RetBean ret) {
        this.ret = ret;
    }

    public static class RetBean {
        /**
         * list : [{"dataId":"ff8080815c5dce45015c5e77b07c0675","likeNum":0,"msg":"超喜欢男神的这部片子，就是喜欢。","phoneNumber":"悲伤的恋曲","time":"2017-05-25 15:25:21","userPic":""},{"dataId":"ff8080815c5dce45015c5e77b0790673","likeNum":0,"msg":"没想到这个电影在手机电影APP里居然可以看到，赞一个。","phoneNumber":"伪装坚强","time":"2017-05-19 20:25:21","userPic":""},{"dataId":"ff8080815c5dce45015c5e77b0760672","likeNum":0,"msg":"呵呵，这种电影，不想评价更多！","phoneNumber":"忧别人之忧","time":"2017-05-18 11:25:21","userPic":""},{"dataId":"ff8080815c5dce45015c5e77b07b0674","likeNum":0,"msg":"这片子早就应该看了，幸好没有错过这么好的片子。","phoneNumber":"陌路丢了谁","time":"2017-05-15 19:25:21","userPic":""}]
         * pnum : 1
         * records : 20
         * totalPnum : 1
         * totalRecords : 4
         */

        private int pnum;
        private int records;
        private int totalPnum;
        private int totalRecords;
        private List<ListBean> list;

        public int getPnum() {
            return pnum;
        }

        public void setPnum(int pnum) {
            this.pnum = pnum;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public int getTotalPnum() {
            return totalPnum;
        }

        public void setTotalPnum(int totalPnum) {
            this.totalPnum = totalPnum;
        }

        public int getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            this.totalRecords = totalRecords;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * dataId : ff8080815c5dce45015c5e77b07c0675
             * likeNum : 0
             * msg : 超喜欢男神的这部片子，就是喜欢。
             * phoneNumber : 悲伤的恋曲
             * time : 2017-05-25 15:25:21
             * userPic :
             */

            private String dataId;
            private int likeNum;
            private String msg;
            private String phoneNumber;
            private String time;
            private String userPic;

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getUserPic() {
                return userPic;
            }

            public void setUserPic(String userPic) {
                this.userPic = userPic;
            }
        }
    }
}
