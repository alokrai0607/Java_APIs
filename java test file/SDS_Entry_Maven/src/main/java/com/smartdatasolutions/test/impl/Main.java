package com.smartdatasolutions.test.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

public class Main extends MemberFileConverter {

    @Override
    protected MemberExporter getMemberExporter() {
        return new MemberExporterImpl();
    }

    @Override
    protected MemberImporter getMemberImporter() {
        return new MemberImporterImpl();
    }

    @Override
    protected List<Member> getNonDuplicateMembers(List<Member> membersFromFile) {
    	 Set<String> memberIds = new HashSet<>();
    	    List<Member> nonDuplicateMembers = new ArrayList<>();
    	    for (Member member : membersFromFile) {
    	        String memberId = member.getId();
    	        if (!memberIds.contains(memberId)) {
    	            memberIds.add(memberId);
    	            nonDuplicateMembers.add(member);
    	        }
    	    }

    	    return nonDuplicateMembers;
    }

    @Override
    protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {
      
        Map<String, List<Member>> stateMap = new HashMap<>();
        
        for (Member member : validMembers) {
            String state = member.getState();
            stateMap.computeIfAbsent(state, k -> new ArrayList<>()).add(member);
        }

        return stateMap;
    }

    public static void main(String[] args) {
       
        try {
            File inputMemberFile = new File("C:\\Users\\91904\\OneDrive\\Desktop\\java test file\\SDS_Entry_Maven\\Members.txt");
            String outputDirectory = "C:\\Users\\91904\\OneDrive\\Desktop\\java test file\\SDS_Entry_Maven";
            String outputFileName = "outputFileName.csv";

            Main converter = new Main();
            converter.convert(inputMemberFile, outputDirectory, outputFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
