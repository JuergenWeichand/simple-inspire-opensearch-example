package de.weichand.inspire.opensearch.dataset.iface;

/**
 * Dataset Configuration<br />
 * 
 * @author Juergen Weichand
 */
public interface ISimpleDatasetConfiguration {
      
    /**
     * @return HTTP-Link to the OpenSearchDescription-Document (TG 5.4)
     */
    public String getOpenSearchDescriptionDocument();
    
    
    /**
     * @return HTTP-Link to the Dataset-Feed (TG 5.4.3)
     */
    public String getDatasetFeed();
    
    /**
     * @param epsg 
     * @return HTTP-Link to the Dataset OR to the Multifile-Feed (TG 5.4.4)
     */
    public String getDataset(int epsg);
        
}
