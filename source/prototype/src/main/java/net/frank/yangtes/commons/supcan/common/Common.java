package net.frank.yangtes.commons.supcan.common;

import java.util.List;

import com.google.common.collect.Lists;
import net.frank.yangtes.commons.supcan.common.fonts.Font;
import net.frank.yangtes.commons.supcan.common.properties.Properties;
import net.frank.yangtes.commons.utils.IdGenUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 硕正Common
 */
public class Common {

	/**
	 * 属性对象
	 */
	@XStreamAlias("Properties")
	protected Properties properties;
	
	/**
	 * 字体对象
	 */
	@XStreamAlias("Fonts")
	protected List<Font> fonts;

	public Common() {
		properties = new Properties(IdGenUtil.uuid());
		fonts = Lists.newArrayList(
				new Font("宋体", "134", "-12"),
				new Font("宋体", "134", "-13", "700"));
	}
	
	public Common(Properties properties) {
		this();
		this.properties = properties;
	}
	
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public List<Font> getFonts() {
		return fonts;
	}

	public void setFonts(List<Font> fonts) {
		this.fonts = fonts;
	}

}
