import { postMediaInstance } from "/apiUtil/instance";

export const uploadFiles = {
  getRes(files) {
    return postMediaInstance.post("/api/video/upload", files);
  },
};
