package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R;

import java.util.HashMap;

/**
 * @Description 声音工具类
 * @Author qc
 */    
@SuppressLint("UseSparseArrays")
public class SoundUtils {    
	SoundPool sp;                           //得到一个声音池引用
	HashMap<Integer, Integer> spMap;           //得到一个map的引用
	private Context context;

	public SoundUtils(final Context context){
		initSoundPool(context);
		this.context = context;
	}
	public void initSoundPool(Context context){            //初始化声音池
		sp = new SoundPool(
				5,              //maxStreams参数，该参数为设置同时能够播放多少音效  
				AudioManager.STREAM_MUSIC,  //streamType参数，该参数设置音频类型，在游戏中通常设置为：STREAM_MUSIC
				0               //srcQuality参数，该参数设置音频文件的质量，目前还没有效果，设置为0为默认值。  
				); 
		spMap = new HashMap<Integer, Integer>();
		spMap.put(1, sp.load(context, R.raw.yz_success, 1)); //验证成功
		spMap.put(2, sp.load(context, R.raw.yz_fail, 1)); //验证失败
		spMap.put(3, sp.load(context, R.raw.yz_fail_bukeyong, 1)); //不可用
		spMap.put(4, sp.load(context, R.raw.yz_fail_guoqi, 1)); //过期
		spMap.put(5, sp.load(context, R.raw.yz_fail_weixiaoshou, 1)); //未销售
		spMap.put(6, sp.load(context, R.raw.yz_fail_wuxiaoka, 1)); //无效卡
		spMap.put(7, sp.load(context, R.raw.yz_fail_wuxinxi, 1)); //无信息
		spMap.put(8, sp.load(context, R.raw.yz_fail_yidongjie, 1)); //已冻结
		spMap.put(9, sp.load(context, R.raw.wushuju, 1)); //暂无数据
		spMap.put(10, sp.load(context, R.raw.bukeyong, 1)); //不可用
		spMap.put(11, sp.load(context, R.raw.weibangd, 1)); //未绑定
		spMap.put(12, sp.load(context, R.raw.wucishu, 1)); //无次数
		spMap.put(13, sp.load(context, R.raw.yiguashi, 1)); //已挂失
		spMap.put(14, sp.load(context, R.raw.yz_fail_no_free, 1)); //无免费次数

	} 
	public void playSound(int sound){    //播放声音,参数sound是播放音效的id，参数number是播放音效的次数  
		AudioManager am=(AudioManager)context.getSystemService(context.AUDIO_SERVICE);//实例化AudioManager对象
		float audioMaxVolumn=am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);  //返回当前AudioManager对象的最大音量值
		float audioCurrentVolumn=am.getStreamVolume(AudioManager.STREAM_MUSIC);//返回当前AudioManager对象的音量值
		float volumnRatio=audioCurrentVolumn/audioMaxVolumn; 
		sp.play( 
				spMap.get(sound),                   //播放的音乐id  
				volumnRatio,                        //左声道音量  
				volumnRatio,                        //右声道音量  
				1,                                  //优先级，0为最低  
				0,                             //循环次数，0无不循环，-1无永远循环  
				1                                   //回放速度 ，该值在0.5-2.0之间，1为正常速度  
				); 
	} 
	public void stop(){
		sp.release();
	}
}    