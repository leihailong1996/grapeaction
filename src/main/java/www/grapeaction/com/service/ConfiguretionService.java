package www.grapeaction.com.service;

import www.grapeaction.com.pojo.Configuretion;
import www.grapeaction.com.util.page.Page;

import java.util.List;

public interface ConfiguretionService {
    public List<Configuretion> getConfiguretionList(Page page);
    public int getConfiguretionSumNum(Page page);
    public int updateConfiguretion(Configuretion configuration);
    public int insertConfiguretion(Configuretion  configuration);
    public int deleteConfiguretion(Configuretion  configuration);

}
