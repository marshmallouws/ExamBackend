/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.Map;

/**
 *
 * @author Annika
 */
public class TomatoScoreDTO {
    private String source;
    private Map<String, Double> viewer;
    private Map<String, Double> critic;
    
    public TomatoScoreDTO() {}

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Map<String, Double> getViewer() {
        return viewer;
    }

    public void setViewer(Map<String, Double> viewer) {
        this.viewer = viewer;
    }

    public Map<String, Double> getCritic() {
        return critic;
    }

    public void setCritic(Map<String, Double> critic) {
        this.critic = critic;
    }
}
