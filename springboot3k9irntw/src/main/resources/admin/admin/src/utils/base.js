const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot3k9irntw/",
            name: "springboot3k9irntw",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot3k9irntw/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于SpringBoot的社区医疗服务管理小程序的设计与开发"
        } 
    }
}
export default base
