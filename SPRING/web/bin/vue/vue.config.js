module.exports = {  
  outputDir: "../src/main/resources/static",  //npm run build로 빌드 시 파일이 생성되는 위치
  indexPath: "../static/index.html",  //index.html 파일이 생성될 위치를 지정
  devServer: {  
	port: 8090,
    proxy: "http://localhost:8090"  //Back-End , 즉 Spring Boot의 내장 was의 주소를 작성
  },  
  chainWebpack: config => {  
    const svgRule = config.module.rule("svg");    
    svgRule.uses.clear();    
    svgRule.use("vue-svg-loader").loader("vue-svg-loader");  
  }  
};