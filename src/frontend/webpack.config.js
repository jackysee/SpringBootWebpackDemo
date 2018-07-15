const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  entry: {
    index: './src/index.js'
  },
  output: {
    filename: '[name].js',
    path: path.resolve(__dirname, 'dist/assets')
  },
  plugins: [
    new HtmlWebpackPlugin({
        inject: false,
        template: 'src/index.ejs',
        filename: '[name]_assets.html'
    })
  ]
};
 
