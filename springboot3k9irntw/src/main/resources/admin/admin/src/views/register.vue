<template>
	<div>
		<div class="register-container">
			<el-form v-if="pageFlag=='register'" ref="ruleForm" class="rgs-form animate__animated animate__" :model="ruleForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">基于SpringBoot的社区医疗服务管理小程序的设计与开发</div>
					<el-form-item class="list-item" v-if="tableName=='huanzhe'">
						<div class="lable" :class="changeRules('yibaokahao')?'required':''">医保卡号：</div>
						<el-input  v-model="ruleForm.yibaokahao"  autocomplete="off" placeholder="医保卡号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='huanzhe'">
						<div class="lable" :class="changeRules('huanzhezhanghao')?'required':''">患者账号：</div>
						<el-input  v-model="ruleForm.huanzhezhanghao"  autocomplete="off" placeholder="患者账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='huanzhe'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='huanzhe'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='huanzhe'">
						<div class="lable" :class="changeRules('huanzhexingming')?'required':''">患者姓名：</div>
						<el-input  v-model="ruleForm.huanzhexingming"  autocomplete="off" placeholder="患者姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='huanzhe'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="huanzhetouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='huanzhe'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in huanzhexingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='huanzhe'">
						<div class="lable" :class="changeRules('huanzhedianhua')?'required':''">患者电话：</div>
						<el-input  v-model="ruleForm.huanzhedianhua"  autocomplete="off" placeholder="患者电话"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='huanzhe'">
						<div class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input  v-model.number="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'">
						<div class="lable" :class="changeRules('yishengzhanghao')?'required':''">医生账号：</div>
						<el-input  v-model="ruleForm.yishengzhanghao"  autocomplete="off" placeholder="医生账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'">
						<div class="lable" :class="changeRules('yishengxingming')?'required':''">医生姓名：</div>
						<el-input  v-model="ruleForm.yishengxingming"  autocomplete="off" placeholder="医生姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="yishengtouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'">
						<div class="lable" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
						<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'">
						<div class="lable" :class="changeRules('zhuanye')?'required':''">专业：</div>
						<el-input  v-model="ruleForm.zhuanye"  autocomplete="off" placeholder="专业"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in yishengxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'">
						<div class="lable" :class="changeRules('zigezheng')?'required':''">资格证：</div>
						<file-upload
							tip="点击上传资格证"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.zigezheng?ruleForm.zigezheng:''"
							@change="yishengzigezhengUploadChange"
						></file-upload>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，点击登录</div>
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            huanzhexingbieOptions: [],
            yishengxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='huanzhe'){
				this.ruleForm = {
					yibaokahao: this.getUUID(),
					huanzhezhanghao: '',
					mima: '',
					huanzhexingming: '',
					touxiang: '',
					xingbie: '',
					huanzhedianhua: '',
					nianling: '',
					sfsh: '',
					shhf: '',
				}
			}
			if(this.tableName=='yisheng'){
				this.ruleForm = {
					yishengzhanghao: '',
					mima: '',
					yishengxingming: '',
					touxiang: '',
					lianxidianhua: '',
					zhuanye: '',
					xingbie: '',
					zigezheng: '',
					sfsh: '',
					shhf: '',
				}
			}
			if ('huanzhe' == this.tableName) {
				this.rules.huanzhezhanghao = [{ required: true, message: '请输入患者账号', trigger: 'blur' }]
			}
			if ('huanzhe' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('huanzhe' == this.tableName) {
				this.rules.huanzhexingming = [{ required: true, message: '请输入患者姓名', trigger: 'blur' }]
			}
			if ('huanzhe' == this.tableName) {
				this.rules.touxiang = [{ required: true, message: '请输入头像', trigger: 'blur' }]
			}
			if ('yisheng' == this.tableName) {
				this.rules.yishengzhanghao = [{ required: true, message: '请输入医生账号', trigger: 'blur' }]
			}
			if ('yisheng' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yisheng' == this.tableName) {
				this.rules.yishengxingming = [{ required: true, message: '请输入医生姓名', trigger: 'blur' }]
			}
			if ('yisheng' == this.tableName) {
				this.rules.touxiang = [{ required: true, message: '请输入头像', trigger: 'blur' }]
			}
			if ('yisheng' == this.tableName) {
				this.rules.zigezheng = [{ required: true, message: '请输入资格证', trigger: 'blur' }]
			}
			this.huanzhexingbieOptions = "男,女".split(',')
			this.yishengxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        huanzhetouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        yishengtouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        yishengzigezhengUploadChange(fileUrls) {
            this.ruleForm.zigezheng = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
			  if(this.tableName=='huanzhe'){
				  this.ruleForm.sfsh = '待审核'
			  }
			if(this.tableName=='huanzhe' && this.ruleForm.yibaokahao){
				this.ruleForm.yibaokahao = String(this.ruleForm.yibaokahao)
			}
			if((!this.ruleForm.huanzhezhanghao) && `huanzhe` == this.tableName){
				this.$message.error(`患者账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `huanzhe` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `huanzhe` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.huanzhexingming) && `huanzhe` == this.tableName){
				this.$message.error(`患者姓名不能为空`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.touxiang) && `huanzhe` == this.tableName){
				this.$message.error(`头像不能为空`);
				return
			}
			if(`huanzhe` == this.tableName && this.ruleForm.huanzhedianhua &&(!this.$validate.isMobile(this.ruleForm.huanzhedianhua))){
				this.$message.error(`患者电话应输入手机格式`);
				return
			}
			if(`huanzhe` == this.tableName && this.ruleForm.nianling &&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
			  if(this.tableName=='yisheng'){
				  this.ruleForm.sfsh = '待审核'
			  }
			if((!this.ruleForm.yishengzhanghao) && `yisheng` == this.tableName){
				this.$message.error(`医生账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `yisheng` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `yisheng` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.yishengxingming) && `yisheng` == this.tableName){
				this.$message.error(`医生姓名不能为空`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.touxiang) && `yisheng` == this.tableName){
				this.$message.error(`头像不能为空`);
				return
			}
			if(`yisheng` == this.tableName && this.ruleForm.lianxidianhua &&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
				this.$message.error(`联系电话应输入手机格式`);
				return
			}
            if(this.ruleForm.zigezheng!=null) {
                this.ruleForm.zigezheng = this.ruleForm.zigezheng.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.zigezheng) && `yisheng` == this.tableName){
				this.$message.error(`资格证不能为空`);
				return
			}
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20240920/478d9d0cf9214f75a492b100481872a4.jpg) no-repeat center center / 100% 100%;
	background: url(http://codegen.caihongy.cn/20240920/478d9d0cf9214f75a492b100481872a4.jpg) no-repeat center center / 100% 100%;
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	position: relative !important;
	.rgs-form {
		.rgs-form2 {
		width: 100%;
		}
		border-radius: 0px;
		padding: 30px 80px 30px 130px;
		margin: 30px auto;
		background: #ffffff;
		width: 600px;
		height: auto;
		.title {
			padding: 0;
			margin: 0 0 20px -120px;
			color: #0674fc;
			background: none;
			font-weight: 600;
			width: calc(100% + 190px);
			font-size: 22px;
			line-height: 40px;
			text-align: center;
		}
		.list-item {
			padding: 0;
			margin: 0 0 10px;
			width: 100%;
			position: relative;
			height: auto;
			/deep/ .el-form-item__content {
				display: block;
			}
			.lable {
				padding: 0 10px 0 0;
				color: #333;
				left: -130px;
				background: none;
				width: auto;
				font-size: 16px;
				line-height: 34px;
				position: absolute !important;
				text-align: right;
				min-width: 130px;
			}
			.el-input {
				width: 100%;
			}
			.el-input /deep/ .el-input__inner {
				border: 1px solid #0674fc;
				border-radius: 0px;
				padding: 0 10px;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 40px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: 1px solid #0674fc;
				border-radius: 0px;
				padding: 0 10px;
				outline: none;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 40px;
			}
			.el-input-number {
				width: 100%;
			}
			.el-input-number /deep/ .el-input__inner {
				text-align: center;
				border: 1px solid #0674fc;
				border-radius: 0px;
				padding: 0 10px;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 40px;
			}
			.el-input-number /deep/ .el-input__inner:focus {
				border: 1px solid #0674fc;
				border-radius: 0px;
				padding: 0 10px;
				outline: none;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 40px;
			}
			.el-input-number /deep/ .el-input-number__decrease {
				display: none;
			}
			.el-input-number /deep/ .el-input-number__increase {
				display: none;
			}
			.el-select {
				width: 100%;
			}
			.el-select /deep/ .el-input__inner {
				border: 1px solid #0674fc;
				border-radius: 0;
				padding: 0 10px;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 38px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: 1px solid #0674fc;
				border-radius: 0;
				padding: 0 10px;
				outline: none;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 38px;
			}
			.el-date-editor {
				width: 100%;
			}
			.el-date-editor /deep/ .el-input__inner {
				border: 1px solid #0674fc;
				border-radius: 0;
				padding: 0 10px 0 30px;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 38px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: 1px solid #0674fc;
				border-radius: 0;
				padding: 0 10px 0 30px;
				outline: none;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 38px;
			}
			.el-date-editor.el-input {
				width: 100%;
			}
			/deep/ .el-upload--picture-card {
				background: transparent;
				border: 0;
				border-radius: 0;
				width: auto;
				height: auto;
				line-height: initial;
				vertical-align: middle;
			}
			/deep/ .upload .upload-img {
				border: 1px solid #0674fc;
				cursor: pointer;
				border-radius: 0;
				color: #0674fc;
				background: none;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid #0674fc;
				cursor: pointer;
				border-radius: 0;
				color: #0674fc;
				background: none;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 1px solid #0674fc;
				cursor: pointer;
				border-radius: 0;
				color: #0674fc;
				background: none;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				color: #666;
				font-size: 15px;
			}
			/deep/ .el-input__inner::placeholder {
				color: #999;
				font-size: 16px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				top: 5px;
				left: 118px;
				position: inherit;
				content: "*";
				order: -1;
			}
			.editor {
				background: #fff;
				width: 100%;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: 1px solid #0674fc;
				border-radius: 0;
				padding: 0 10px;
				margin: 0;
				color: #666;
				background: none;
				flex: 1;
				width: 100%;
				font-size: 15px;
				height: 38px;
			}
			input:focus {
				border: 1px solid #0674fc;
				border-radius: 0;
				padding: 0 10px;
				outline: none;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 38px;
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
			button {
				border: 0px solid #e6e6e6;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0 0 0 10px;
				color: #fff;
				background: #0674fc;
				width: 150px;
				font-size: 15px;
				height: 38px;
			}
			button:hover {
				opacity: 0.9;
			}
		}
		.register-btn {
			display: flex;
			width: 100%;
			flex-wrap: wrap;
		}
		.register-btn1 {
			width: 100%;
			order: 2;
		}
		.register-btn2 {
			width: 100%;
		}
		.r-btn {
			border: 0px solid rgba(0, 0, 0, 1);
			cursor: pointer;
			padding: 0 10px;
			margin: 0 0 10px;
			color: #fff;
			font-weight: 600;
			letter-spacing: 10px;
			font-size: 22px;
			border-radius: 0;
			background: #0674fc;
			width: 100%;
			min-width: 68px;
			height: 50px;
		}
		.r-btn:hover {
			border: 0px solid rgba(0, 0, 0, 1);
			opacity: 0.9;
		}
		.r-login {
			cursor: pointer;
			padding: 0;
			color: #999;
			display: inline-block;
			width: 100%;
			font-size: 15px;
			line-height: 50px;
			text-align: right;
		}
		.r-login:hover {
			opacity: 1;
		}
	}
}
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
