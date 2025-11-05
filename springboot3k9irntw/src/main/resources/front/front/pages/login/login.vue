<template>
	<view class="content">
		<view class="box" :style='{"width":"100%","padding":"0","alignItems":"center","background":"url(http://codegen.caihongy.cn/20241221/0a6a48ef0d2a463a951920312c2aea25.png) top center/100% 55% no-repeat","display":"flex","height":"100%"}'>
			<view :style='{"padding":"30rpx 30rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgba(0, 0, 0, 0.25)","margin":"0 auto","flexWrap":"wrap","background":"#fff","display":"flex","width":"80%","position":"relative","height":"auto"}'>
				<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"8rpx","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
				<view v-if="loginType==1" :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' class="uni-form-item uni-column">
					<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">账号：</view>
					<input v-model="username" :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","width":"calc(100% - 130rpx)","fontSize":"28rpx","height":"70rpx"}' type="text" class="uni-input" name="" placeholder="请输入账号" />
				</view>
				<view v-if="loginType==1" :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' class="uni-form-item uni-column">
					<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">密码：</view>
					<input v-model="password" :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","width":"calc(100% - 130rpx)","fontSize":"28rpx","height":"70rpx"}' type="password" class="uni-input" name="" placeholder="请输入密码" />
				</view>
				<view v-if="roleNum>1" :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"4"}'>
					<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">用户类型：</view>
					<picker @change="optionsChange" :value="index" :range="options" :style='{"padding":"0 20rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#000","flex":"1"}'>
						<view class="uni-picker-type">{{options[index]}}</view>
					</picker>
				</view>
				

				
				<button v-if="loginType==1" class="btn-submit" @tap="onLoginTap" type="primary" :style='{"border":"0","padding":"0px","margin":"0 auto -40rpx","color":"#000","borderRadius":"8rpx","background":"linear-gradient(135.00deg, rgb(228, 173, 215) 0%,rgb(188, 255, 253) 100%)","width":"60%","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"bold","height":"80rpx","order":"6"}'>登陆</button>
				<button v-if="loginType==2" class="btn-submit" @tap="onFaceLoginTap" type="primary" :style='{"border":"0","padding":"0px","margin":"0 auto -40rpx","color":"#000","borderRadius":"8rpx","background":"linear-gradient(135.00deg, rgb(228, 173, 215) 0%,rgb(188, 255, 253) 100%)","width":"60%","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"bold","height":"80rpx","order":"6"}'>人脸识别登录</button>
				<view class="links" :style='{"padding":"0","margin":"0 0 24rpx 0","top":"calc(100% + 60rpx)","flexWrap":"wrap","left":"0","display":"flex","width":"100%","position":"absolute","justifyContent":"space-between","height":"auto","order":"7"}'>
					<view class="link-highlight" @tap="onRegisterTap('huanzhe')" :style='{"padding":"0 8rpx","margin":"0 0 10rpx","color":"#000","textAlign":"center","background":"linear-gradient(0.00deg, rgb(255, 255, 255),rgb(255, 233, 250) 100%)","width":"45%","fontSize":"28rpx","lineHeight":"60rpx","height":"60rpx"}'>注册患者</view>
				</view>
				
				<view class="idea1" :style='{"color":"#000","textAlign":"center","background":"none","display":"block","width":"100%","fontSize":"30rpx","fontWeight":"bold","height":"80rpx","order":"1"}'>登录</view>
				<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
				<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
			</view>
		</view>
	</view>
</template>

<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				username: '',
				password: '',
                loginType:1,
				codes: [{
				  num: 1,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 2,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 3,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 4,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}],
				options: [
					'请选择登录用户类型',
				],
                optionsValues: [
					'',
                    'huanzhe',
				],
				index: 0,
				roleNum:0,

			}
		},
		onLoad() {
			let options = ['请选择登录用户类型'];
			let menus = menu.list();
			this.menuList = menus;
			for(let i=0;i<this.menuList.length;i++){
				if(this.menuList[i].hasFrontLogin=='是'){
					options.push(this.menuList[i].roleName);
					this.roleNum++;
				}
			}
			if(this.roleNum==1) {
				this.index = 1;
			}	
			this.options = options;
			this.styleChange()
		},
		onShow() {
		},
		mounted() {
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.loginFrom.content.input.backgroundColor
					// })
				})
			},
			onRegisterTap(tableName) {
                uni.setStorageSync("loginTable", tableName);
				this.$utils.jump('../register/register')
			},
			async onLoginTap() {
                if (!this.username) {
					this.$utils.msg('请输入用户名')
					return
				}
                if (!this.password) {
					this.$utils.msg('请输入用户密码')
					return
				}
                if (!this.optionsValues[this.index]) {
					this.$utils.msg('请选择登录用户类型')
					return
				}

				this.loginPost()

			},
			async loginPost() {
				
				let res = await this.$api.login(`${this.optionsValues[this.index]}`, {
					username: this.username,
					password: this.password
				});
				uni.removeStorageSync("useridTag");
				uni.setStorageSync("appToken", res.token);
				uni.setStorageSync("nickname",this.username);
				uni.setStorageSync("nowTable", `${this.optionsValues[this.index]}`);
				res = await this.$api.session(`${this.optionsValues[this.index]}`);
				if(res.data.touxiang) {
				    uni.setStorageSync('headportrait', res.data.touxiang);
				} else if(res.data.headportrait) {
				    uni.setStorageSync('headportrait', res.data.headportrait);
				}
				uni.setStorageSync('userSession',JSON.stringify(res.data))
				// 保存用户id
				uni.setStorageSync("appUserid", res.data.id);
				if(res.data.vip) {
					uni.setStorageSync("vip", res.data.vip);
				}
				uni.setStorageSync("appRole", `${this.options[this.index]}`);
				this.$utils.tab('../index/index');
			},
			optionsChange(e) {
				this.index = e.target.value
			}
		}
	}
</script>

<style lang="scss" scoped>
	page {
		height: 100%;
	}
	
	.content {
		height: 100%;
		box-sizing: border-box;
	}
	
</style>
