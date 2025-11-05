<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100%","padding":"20rpx","alignItems":"flex-start","background":"linear-gradient(135.00deg, rgb(206, 209, 242),rgb(228, 185, 225) 100%)","display":"flex","width":"100%","height":"auto"}'>
		<view :style='{"width":"100%","padding":"24rpx","borderRadius":"20rpx","background":"#fff","display":"block","height":"auto"}'>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='huanzhe'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}'>医保卡号</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}' v-model="ruleForm.yibaokahao" placeholder="医保卡号"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='huanzhe'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}'>患者账号</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}' disabled="true"  v-model="ruleForm.huanzhezhanghao" placeholder="患者账号"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='huanzhe'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}'>患者姓名</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}'   v-model="ruleForm.huanzhexingming" placeholder="患者姓名"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='huanzhe'" @tap="huanzhetouxiangTap" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}'>头像</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view v-if="tableName=='huanzhe'" :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="huanzhexingbieChange" :value="huanzhexingbieIndex" :range="huanzhexingbieOptions">
					<view :style='{"width":"100%","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#D4C1D6"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='huanzhe'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}'>患者电话</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}'   v-model="ruleForm.huanzhedianhua" placeholder="患者电话"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='huanzhe'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}'>年龄</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}'   v-model="ruleForm.nianling" placeholder="年龄"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yisheng'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}'>医生账号</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}' disabled="true"  v-model="ruleForm.yishengzhanghao" placeholder="医生账号"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yisheng'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}'>医生姓名</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}'   v-model="ruleForm.yishengxingming" placeholder="医生姓名"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yisheng'" @tap="yishengtouxiangTap" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}'>头像</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yisheng'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}'>联系电话</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}'   v-model="ruleForm.lianxidianhua" placeholder="联系电话"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yisheng'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}'>专业</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}'   v-model="ruleForm.zhuanye" placeholder="专业"></input>
			</view>
			<view v-if="tableName=='yisheng'" :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="yishengxingbieChange" :value="yishengxingbieIndex" :range="yishengxingbieOptions">
					<view :style='{"width":"100%","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#D4C1D6"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yisheng'" @tap="yishengzigezhengTap" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}'>资格证</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.zigezheng" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.zigezheng" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"padding":"20rpx 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"center","height":"auto"}' class="btn">
				<button @tap="update()" class="cu-btn lg" :style='{"border":"0","padding":"0px","margin":"0 0 20rpx","color":"rgb(255, 255, 255)","background":"#E4AED7","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}'>保存</button>
				<button @tap="logout()" class="cu-btn lg" :style='{"border":"0","padding":"0px","margin":"0","color":"rgb(255, 255, 255)","background":"#000","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}'>退出登录</button>
			</view>
		</view>
	</view>
</view>
</template>

<script>

    import xiaEditor from '@/components/xia-editor/xia-editor';
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				ruleForm: {
				},
				tableName:"",
				huanzhexingbieOptions: [],
				huanzhexingbieIndex: 0,
				yishengxingbieOptions: [],
				yishengxingbieIndex: 0,
			}
		},
        components: {
            multipleSelect,
			xiaEditor
        },
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onLoad() {
			let table = uni.getStorageSync("nowTable");
			let that = this
			let res = {}
			this.tableName = table;
			this.getSession()
			// 自定义下拉框值
			if(this.tableName=='huanzhe'){
				this.huanzhexingbieOptions = "男,女".split(',');
				this.huanzhexingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.huanzhexingbieIndex = index;
					}
				});
			}
			// 自定义下拉框值
			if(this.tableName=='yisheng'){
				this.yishengxingbieOptions = "男,女".split(',');
				this.yishengxingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.yishengxingbieIndex = index;
					}
				});
			}
			this.styleChange()
            this.$forceUpdate()
		},
		methods: {
			async getSession(){
				let res = await this.$api.session(this.tableName)
				this.ruleForm = res.data;
				uni.setStorageSync('userSession',JSON.stringify(res.data))
			},
			huanzhetouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},
            // 下拉变化
            huanzhexingbieChange(e) {
                    this.huanzhexingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.huanzhexingbieOptions[this.huanzhexingbieIndex]
            },
			yishengtouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},
            // 下拉变化
            yishengxingbieChange(e) {
                    this.yishengxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.yishengxingbieOptions[this.yishengxingbieIndex]
            },
			yishengzigezhengTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.zigezheng = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('. .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.userInfoForm.list.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			logout() {
				uni.clearStorageSync()
				this.$utils.jump('../login/login');
			},
			// 注册
			async update() {


				if((!this.ruleForm.huanzhezhanghao) && `huanzhe` == this.tableName){
					this.$utils.msg(`患者账号不能为空`);
					return
				}

				if((!this.ruleForm.mima) && `huanzhe` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}

				if((!this.ruleForm.huanzhexingming) && `huanzhe` == this.tableName){
					this.$utils.msg(`患者姓名不能为空`);
					return
				}

				if((!this.ruleForm.touxiang) && `huanzhe` == this.tableName){
					this.$utils.msg(`头像不能为空`);
					return
				}


				if(`huanzhe` == this.tableName && this.ruleForm.huanzhedianhua&&(!this.$validate.isMobile(this.ruleForm.huanzhedianhua))){
					this.$utils.msg(`患者电话应输入手机格式`);
					return
				}

				if(`huanzhe` == this.tableName && this.ruleForm.nianling&&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
					this.$utils.msg(`年龄应输入整数`);
					return
				}



				if((!this.ruleForm.yishengzhanghao) && `yisheng` == this.tableName){
					this.$utils.msg(`医生账号不能为空`);
					return
				}

				if((!this.ruleForm.mima) && `yisheng` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}

				if((!this.ruleForm.yishengxingming) && `yisheng` == this.tableName){
					this.$utils.msg(`医生姓名不能为空`);
					return
				}

				if((!this.ruleForm.touxiang) && `yisheng` == this.tableName){
					this.$utils.msg(`头像不能为空`);
					return
				}

				if(`yisheng` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}



				if((!this.ruleForm.zigezheng) && `yisheng` == this.tableName){
					this.$utils.msg(`资格证不能为空`);
					return
				}


				let table = uni.getStorageSync("nowTable");
				await this.$api.update(table, this.ruleForm);
				this.$utils.msgBack('修改成功');;
				this.getSession()
			},

		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
