package com.learning.java.samples.level3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsBasic
{
    // Generic method
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static List<Integer> merge(final List<Integer> left, final List<Integer> right) {
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while(i < left.size() && j < right.size()) {
            if(left.get(i) < right.get(j)) {
                result.add(left.get(i));
                i++;
            }
            else {
                result.add(right.get(j));
                j++;
            }
        }
        while(i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        while(j < right.size()) {
            result.add(right.get(j));
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> left = List.of(1, 3, 5, 7, 9);
        List<Integer> right = List.of(2, 4, 6, 8, 10);
        System.out.println(merge(left, right));
    }
}
