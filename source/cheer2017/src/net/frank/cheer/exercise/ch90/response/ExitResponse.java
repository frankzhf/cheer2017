package net.frank.cheer.exercise.ch90.response;

import net.frank.cheer.exercise.ch90.define.Request;
import net.frank.cheer.exercise.ch90.define.Response;

/***
 * 
 *
 */
public class ExitResponse implements Response {

	@Override
	public void render(Request request) {
		System.out.println("谢谢使用！");
		System.exit(0);
	}

}
