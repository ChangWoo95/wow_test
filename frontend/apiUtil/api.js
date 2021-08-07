// import axios from "axios";
import { postMediaInstance } from "/apiUtil/instance";

/* 시스템 - 업무구분 콤보박스 */
// export const getCtmmnySys = {
//   getRes() {
//     return instance.get("/api/cust/sys");
//   },
// };
export const uploadFiles = {
  getRes(files) {
    return postMediaInstance.post("/api/upload/video", files);
  },
};
