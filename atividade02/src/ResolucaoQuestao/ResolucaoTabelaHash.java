package ResolucaoQuestao;

import java.util.HashMap;
import java.util.Map;

public class ResolucaoTabelaHash {
    
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tabelaHash = new HashMap<>();
        int complemento = 0;

        for (int i=0;i<nums.length;i++){
            complemento= target-nums[i];
            if(tabelaHash.containsKey(complemento)){
                int[] resposta = {tabelaHash.get(complemento),i};
                return resposta;
            }
            tabelaHash.put(nums[i],i);
            
        }
        return new int[0];
    }
}