import axios from "axios";

const instance = axios.create({
  baseURL: "http://localhost:9090",
});

const postMediaInstance = axios.create({
  baseURL: "http://localhost:9090",
  headers: {
    "Content-Type": "multipart/form-data",
  },
});

// instance.interceptors.request.use(function (config) {
//   if ( localStorage.getItem("token") !== null) {
//     config['headers'] = {
//       Authorization: `Bearer ${localStorage.getItem("token")}`
//     };
//   }

//   return config;
// });

// instance.interceptors.response.use(function (response) {
//   store.commit('error/setValidationError', {});

//   return response;
// }, function (error) {
//   if (error.response.status === 422) {
//     store.commit('error/setValidationError', error.response.data.data);
//   } else {
//     return Promise.reject(error);
//   }
// });

export { instance, postMediaInstance };
