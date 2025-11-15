package com.Linus.service;

import com.Linus.database.MemberRegistry;
import com.Linus.entity.Member;

import java.util.*;

public class MembershipService {

    private final MemberRegistry memberRegistry;

    public MembershipService(MemberRegistry memberRegistry) {
        this.memberRegistry = memberRegistry;
    }

    public Member registerMember(String name, String statusLevel) {
        Member addMember = new Member(name, statusLevel);
        memberRegistry.addMember(addMember);
        return addMember;
    }

    public List<Member> listAllMembers() {
        return memberRegistry.listAllMembers();
    }

    public boolean lookForMember(String name) {
        List<Member> allMembers = listAllMembers();
        List<String> allMemberNames = new ArrayList<>();
        for (Member member : allMembers) {
            allMemberNames.add(member.getName());
        }
        return allMemberNames.contains(name);
    }

        public void changeStatus(String name, String newStatusLevel) {
        Member changeStatusMember = memberRegistry.findByName(name);
        changeStatusMember.setStatusLevel(newStatusLevel);
        System.out.println(changeStatusMember.getName() + " is now a " + changeStatusMember.getStatusLevel() + " member ");
        }

        public Member findByName(String name) {
        return memberRegistry.findByName(name);
    }



}

















