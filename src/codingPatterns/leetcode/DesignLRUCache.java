package codingPatterns.leetcode;
/*
1. create a dummy head and tail node
head     tail
 |        |
Nod1<--->Nod2

2. insert a key - check if map have enough space
--if yes insert after head
head              tail
 |                 |
Nod1<--->Nodx<--->Nod2

Map<Key, Nodx>
--if no delete node before tail and insert new node after head
 */
public class DesignLRUCache {
}
