/**
 * <p>Title: AreaUtil</p>
 * <p>Description: 格式化地区</p>
 */

package net.frank.yangtes.prototype.util;

import java.util.List;

import net.frank.yangtes.modules.sys.entity.Area;
import net.frank.yangtes.modules.sys.utils.UserUtils;
import net.frank.yangtes.prototype.Constant;
import net.frank.yangtes.prototype.Constant.AREA;


/**
 * @author zhao
 * @date 2017年2月23日 下午1:55:43
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified				
 *				
 * -------------------------------------------------------------------------
 */
public final class AreaUtil extends UserUtils{
	
	/**
     * <p>Title: formName</p>
     * <p>Description:格式化显示地区</p>
     * @param areaId String
     * @return String
     */
	public final static String formatName(String areaId){
		StringBuffer sb = new StringBuffer(64);
		List<Area> list = UserUtils.getAreaList();
		Area _selected = null;
		Area _4 = null;
		Area _3 = null;
		Area _2 = null;
		if(list!=null && !list.isEmpty()){
			for(int i=0;i<list.size();i++){
				Area _item = list.get(i);
				if(areaId.equals(_item.getId())){
					_selected = _item;
					break;
				}
			}
			if(_selected==null){
				sb.append(Constant.UNDEFINE_AREA);
			}else{
				if(AREA.TOWN.equals(_selected.getType())){
					_4 = _selected;
					String _3id = _4.getParentId();
					for(int i=0;i<list.size();i++){
						Area _item = list.get(i);
						if(_3id.equals(_item.getId())){
							_3 = _item;
							break;
						}
					}
					if(Constant.SKIP_AREA_NAME.SHIXIAQU.equals(_3.getName()) 
							|| Constant.SKIP_AREA_NAME.XIAN.equals(_3.getName())
					){
						String _2id = _3.getParentId();
						for(int i=0;i<list.size();i++){
							Area _item = list.get(i);
							if(_2id.equals(_item.getId())){
								_2 = _item;
							}
						}
						sb.append(_2.getName()).append(_4.getName());
					}else{
						sb.append(_3.getName()).append(_4.getName());
					}
				}else if (Constant.AREA.CITY.equals(_selected.getType())){
					_3 = _selected;
					String _2id = _3.getParentId();
					for(int i=0;i<list.size();i++){
						Area _item = list.get(i);
						if(_2id.equals(_item.getId())){
							_2 = _item;
						}
					}
					sb.append(_2.getName()).append(_3.getName());
				}else if (Constant.AREA.STATE.equals(_selected.getType())){
					_2 = _selected;
					sb.append(_2.getName());
				}
				
			}
		}
		return sb.toString();
	}
	
}