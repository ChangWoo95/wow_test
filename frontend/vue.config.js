module.exports = {
  chainWebpack: (config) => {
    //   config.module
    //     .rule("mpd")
    //     .test(/\.mpd$/)
    //     .use("file-loader")
    //     .tap((options) => {
    //       options.name = "[path][name].[ext]";
    //       return options;
    //     })
    //     .loader("file-loader")
    //     .end();
    config.module
      .rule()
      .test(/\.(ogg|mp3|wav|mpe?g|mpd|mp4|m4s)$/i)
      .use("file-loader")
      .loader("file-loader")
      .tap((options) => {
        options = Object();
        options.name = "[path][name].[ext]";
        return options;
      })
      .end();
    //   // config.module.rules.push({
    //   //   test: /\.(ogg|mp3|wav|mpe?g|OTHER_AUDIO_FILE_EXTENSIONS_LIKE_MP4S)$/i,
    //   //   loader: "file-loader",
    //   //   options: {
    //   //     name: "[path][name].[ext]",
    //   //   },
    //   // });
  },
  // build: {
  //   extend(config, ctx) {
  //     config.module.rules.push({
  //       test: /\.(ogg|mp3|wav|mpe?g|OTHER_AUDIO_FILE_EXTENSIONS_LIKE_MP4S)$/i,
  //       loader: "file-loader",
  //       options: {
  //         name: "[path][name].[ext]",
  //       },
  //     });
  //   },
  // },
  // rules: [
  //   {
  //     test: /\.mpd$/,
  //     loader: "file-loader",
  //   },
  // ],

  // chainWebpack: (config) => {
  //   config.plugin("file").tap((args) => {
  //     return [/\.mpd$/];
  //   });
  // },

  transpileDependencies: ["vuetify"],
  publicPath: "",
};

// const replace = require("replace-in-file");
// // eslint-disable-next-line import/no-extraneous-dependencies
// const ResponsiveLoader = require("responsive-loader/sharp");
// // eslint-disable-next-line import/no-extraneous-dependencies
// const path = require("path");

// module.exports = {
//   configureWebpack: {
//     // See https://github.com/webpack/docs/wiki/build-performance#sourcemaps
//     // And devtool must be `eval` for istanbul coverage to work on .vue files
//     // https://github.com/istanbuljs/nyc/issues/718#issuecomment-569346546
//     devtool: process.env.NODE_ENV === "production" ? "source-map" : "eval",
//   },
//   chainWebpack: (config) => {
//     // When using lerna and simlinks,
//     // mode some modules that should be ignored are not
//     // we add them here to avoid errors
//     const vueBrowserCompilerPath = path.resolve(
//       path.dirname(require.resolve("vue-inbrowser-compiler")),
//       "../"
//     );

//     const eslintRule = config.module.rule("eslint");
//     if (eslintRule) {
//       const vsgPath = path.resolve(
//         path.dirname(require.resolve("vue-styleguidist")),
//         "../"
//       );
//       const docgenPath = path.resolve(
//         path.dirname(require.resolve("vue-docgen-api")),
//         "../"
//       );

//       eslintRule.exclude.add(vsgPath);
//       eslintRule.exclude.add(docgenPath);
//       eslintRule.exclude.add(vueBrowserCompilerPath);
//     }

//     const jsRule = config.module.rule("js");
//     if (jsRule) {
//       jsRule.exclude.add(vueBrowserCompilerPath);
//     }

//     if (process.env.BABEL_ENV === "test") {
//       // https://github.com/istanbuljs/nyc/issues/718#issuecomment-569346546
//       replace.sync({
//         files: "node_modules/istanbul-lib-source-maps/lib/get-mapping.js",
//         from: "source: pathutils.relativeTo(start.source, origFile),",
//         to: "source: origFile,",
//       });
//     }

//     config.module
//       .rule("vue")
//       .use("vue-loader")
//       .loader("vue-loader")
//       .tap((options) => ({
//         ...options,
//         transformAssetUrls: {
//           video: ["src", "poster"],
//           source: "src",
//           img: "src",
//           image: "xlink:href",
//           "v-img": ["src", "srcset", "lazy-src"],
//           "v-card": "src",
//           "v-card-media": "src",
//           "v-responsive": "src",
//         },
//       }));

//     config.module
//       .rule("gifs")
//       .test(/\.(gif)$/i)
//       .use("file-loader")
//       .loader("file-loader");

//     config.module.rule("images").uses.clear();

//     config.module
//       .rule("responsive-images")
//       .test(/\.(jpe?g|png)$/i)
//       .use("responsive-loader")
//       .loader("responsive-loader")
//       .tap((options) => ({
//         ...options,
//         adapter: ResponsiveLoader,
//         sizes: [250, 600, 1200, 3000],
//         placeholder: true,
//         placeholderSize: 50,
//         disable: process.env.NODE_ENV !== "production",
//       }));
//   },
//   css: {
//     loaderOptions: {
//       scss: {
//         prependData: '@import "@/scss/colors.scss";',
//       },
//     },
//   },
//   transpileDependencies: [
//     "regexpu-core",
//     "strip-ansi",
//     "ansi-regex",
//     "ansi-styles",
//     "react-dev-utils",
//     "chalk",
//     "unicode-match-property-ecmascript",
//     "unicode-match-property-value-ecmascript",
//     "acorn-jsx",
//     "vuetify",
//     "camelcase",
//   ],
// };
