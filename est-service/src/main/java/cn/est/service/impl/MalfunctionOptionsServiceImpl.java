package cn.est.service.impl;
import cn.est.mapper.MalfunctionOptionsMapper;
import cn.est.po.MalfunctionOptions;
import cn.est.service.MalfunctionOptionsService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class MalfunctionOptionsServiceImpl implements MalfunctionOptionsService {

    @Autowired
    private MalfunctionOptionsMapper malfunctionOptionsMapper;

    public MalfunctionOptions getMalfunctionOptionsById(Long id){
        return malfunctionOptionsMapper.getMalfunctionOptionsById(id);
    }

    public List<MalfunctionOptions>	getMalfunctionOptionsListByMap(Map<String,Object> param){
        return malfunctionOptionsMapper.getMalfunctionOptionsListByMap(param);
    }

    public Integer getMalfunctionOptionsCountByMap(Map<String,Object> param){
        return malfunctionOptionsMapper.getMalfunctionOptionsCountByMap(param);
    }

    public Integer qdtxAddMalfunctionOptions(MalfunctionOptions malfunctionOptions){
            malfunctionOptions.setCreatdTime(new Date());
            return malfunctionOptionsMapper.insertMalfunctionOptions(malfunctionOptions);
    }

    public Integer qdtxModifyMalfunctionOptions(MalfunctionOptions malfunctionOptions){
        malfunctionOptions.setUpdatedTime(new Date());
        return malfunctionOptionsMapper.updateMalfunctionOptions(malfunctionOptions);
    }

    public Integer qdtxDeleteMalfunctionOptionsById(Long id){
        return malfunctionOptionsMapper.deleteMalfunctionOptionsById(id);
    }

    public Integer qdtxBatchDeleteMalfunctionOptions(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return malfunctionOptionsMapper.batchDeleteMalfunctionOptions(param);
    }

    public Page<MalfunctionOptions> queryMalfunctionOptionsPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = malfunctionOptionsMapper.getMalfunctionOptionsCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<MalfunctionOptions> malfunctionOptionsList = malfunctionOptionsMapper.getMalfunctionOptionsListByMap(param);
        page.setList(malfunctionOptionsList);
        return page;
     }


}
