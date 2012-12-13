package de.weichand.inspire.opensearch.dataset;

import de.weichand.inspire.opensearch.dataset.iface.ISimpleDatasetConfiguration;
import de.weichand.inspire.opensearch.dataset.impl.Dgm200Impl;
import de.weichand.inspire.opensearch.dataset.impl.Dtk500Impl;
import de.weichand.inspire.opensearch.exception.OpenSearchException;

/**
 * Dataset Configuration Factory<br />
 * 
 * @author Juergen Weichand
 */
public class DatasetConfigurationFactory {
    
    public static ISimpleDatasetConfiguration getDataset(String alias) throws OpenSearchException {
                
        if (alias.toLowerCase().equals("dgm200")) {
            return new Dgm200Impl();
        }
        if (alias.toLowerCase().equals("dtk500")) {
            return new Dtk500Impl();
        }        
        
        throw new OpenSearchException("Dataset " + alias + " not found!");        
    }
    
}
