package cn.est.service.impl;
import cn.est.mapper.ModelMapper;
import cn.est.po.Model;
import cn.est.service.ModelService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelMapper modelMapper;

    public Model getModelById(Long id){
        return modelMapper.getModelById(id);
    }

    public List<Model>	getModelListByMap(Map<String,Object> param){
        return modelMapper.getModelListByMap(param);
    }

    public Integer getModelCountByMap(Map<String,Object> param){
        return modelMapper.getModelCountByMap(param);
    }

    public Integer qdtxAddModel(Model model){
            model.setCreatdTime(new Date());
            return modelMapper.insertModel(model);
    }

    public Integer qdtxModifyModel(Model model){
        model.setUpdatedTime(new Date());
        return modelMapper.updateModel(model);
    }

    public Integer qdtxDeleteModelById(Long id){
        return modelMapper.deleteModelById(id);
    }

    public Integer qdtxBatchDeleteModel(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return modelMapper.batchDeleteModel(param);
    }

    public Page<Model> queryModelPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = modelMapper.getModelCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<Model> modelList = modelMapper.getModelListByMap(param);
        page.setList(modelList);
        return page;
     }


}
