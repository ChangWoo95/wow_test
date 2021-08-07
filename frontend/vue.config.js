const path = require("path");

module.exports = {
  outputDir: path.resolve(__dirname, "../src/main/resources/static"),
  indexPath: path.resolve(__dirname, "../src/main/resources/static/index.html"),

  devServer: {
    proxy: {
      "": {
        target: "http://localhost:8080",
        ws: true,
        changeOrigin: true,
        disableHostCheck: true,
      },
    },
  },

  transpileDependencies: ["vuetify"],
};
