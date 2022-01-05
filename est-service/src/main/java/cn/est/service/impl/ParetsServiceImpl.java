package cn.est.service.impl;
import cn.est.mapper.ParetsMapper;
import cn.est.po.Parets;
import cn.est.service.ParetsService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class ParetsServiceImpl implements ParetsService {

    @Autowired
    private ParetsMapper paretsMapper;

    public Parets getParetsById(Long id){
        return paretsMapper.getParetsById(id);
    }

    public List<Parets>	getParetsListByMap(Map<String,Object> param){
        return paretsMapper.getParetsListByMap(param);
    }

    public Integer getParetsCountByMap(Map<String,Object> param){
        return paretsMapper.getParetsCountByMap(param);
    }

    public Integer qdtxAddParets(Parets parets){
            parets.setCreatdTime(new Date());
            return paretsMapper.insertParets(parets);
    }

    public Integer qdtxModifyParets(Parets parets){
        parets.setUpdatedTime(new Date());
        return paretsMapper.updateParets(parets);
    }

    public Integer qdtxDeleteParetsById(Long id){
        return paretsMapper.deleteParetsById(id);
    }

    public Integer qdtxBatchDeleteParets(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return paretsMapper.batchDeleteParets(param);
    }

    public Page<Parets> queryParetsPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = paretsMapper.getParetsCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<Parets> paretsList = paretsMapper.getParetsListByMap(param);
        page.setList(paretsList);
        return page;
     }


}
