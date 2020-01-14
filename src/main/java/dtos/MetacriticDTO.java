/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Annika
 */
public class MetacriticDTO {
    
    private String source;
    private String metacritic;
    
    public MetacriticDTO() {
    }
    
    public MetacriticDTO(String source, String metacritic) {
        this.source = source;
        this.metacritic = metacritic;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(String metacritic) {
        this.metacritic = metacritic;
    }
}
