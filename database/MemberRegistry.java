package com.Linus.database;

import com.Linus.entity.Member;

import java.util.*;

public class MemberRegistry {

    public MemberRegistry() {}

    private Map<Long, Member> memberList = new HashMap<>();

    //Metoder

    public void addMember(Member member) {memberList.put(member.getId(), member);
    }
    public Member findById(long id){return memberList.get(id);}

    public Member findByName(String name){
        return memberList.values().stream().filter(member -> member.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
    public List<Member> listAllMembers() {
        return new ArrayList<>(this.memberList.values());
    }



    }









