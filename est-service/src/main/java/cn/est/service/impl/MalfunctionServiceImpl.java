package cn.est.service.impl;
import cn.est.mapper.MalfunctionMapper;
import cn.est.po.Malfunction;
import cn.est.service.MalfunctionService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class MalfunctionServiceImpl implements MalfunctionService {

    @Autowired
    private MalfunctionMapper malfunctionMapper;

    public Malfunction getMalfunctionById(Long id){
        return malfunctionMapper.getMalfunctionById(id);
    }

    public List<Malfunction>	getMalfunctionListByMap(Map<String,Object> param){
        return malfunctionMapper.getMalfunctionListByMap(param);
    }

    public Integer getMalfunctionCountByMap(Map<String,Object> param){
        return malfunctionMapper.getMalfunctionCountByMap(param);
    }

    public Integer qdtxAddMalfunction(Malfunction malfunction){
            malfunction.setCreatdTime(new Date());
            return malfunctionMapper.insertMalfunction(malfunction);
    }

    public Integer qdtxModifyMalfunction(Malfunction malfunction){
        malfunction.setUpdatedTime(new Date());
        return malfunctionMapper.updateMalfunction(malfunction);
    }

    public Integer qdtxDeleteMalfunctionById(Long id){
        return malfunctionMapper.deleteMalfunctionById(id);
    }

    public Integer qdtxBatchDeleteMalfunction(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return malfunctionMapper.batchDeleteMalfunction(param);
    }

    public Page<Malfunction> queryMalfunctionPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = malfunctionMapper.getMalfunctionCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<Malfunction> malfunctionList = malfunctionMapper.getMalfunctionListByMap(param);
        page.setList(malfunctionList);
        return page;
     }


}
