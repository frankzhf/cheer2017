package net.frank.cheer.exercise.ch90.request;

import net.frank.cheer.exercise.ch90.TaiShan;
import net.frank.cheer.exercise.ch90.define.Request;

public class ViewRequest implements Request {

	@Override
	public boolean input() {
		if(TaiShan.data.size()>0){
			return true;
		}else{
			System.out.println("当前没有学生记录，请先增加学生信息！");
			return false;
		}
	}

}
