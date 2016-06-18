package com.github.liuxboy.harbour.simulation.service;


import com.github.liuxboy.harbour.simulation.domain.biz.Result;
import org.apache.avalon.framework.service.ServiceException;

import java.util.List;

/**
 * <p>Title: HarbourSimulationService</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/2 14:57</p>
 * <p>Description: 模拟船舶服务组件 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public interface HarbourSimulationService {
    /**
     * 开始模拟
     * @return
     * @throws ServiceException
     */
    public List<Result> simulation() throws ServiceException;
}
