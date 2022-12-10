#include <iostream>
#include "CTreeStatic.h"
#include "CTreeDynamic.h"

using namespace std;

int main() {


    //First TreeStatic 
  /*
      3
     /     5
    /    /
    0 - 2 - 4 -7
     \   \
      \   6
       1
       */
    CTreeStatic staticTree1;

    staticTree1.pcGetRoot()->vSetValue(0);

    staticTree1.pcGetRoot()->vAddNewChild();
    staticTree1.pcGetRoot()->vAddNewChild();
    staticTree1.pcGetRoot()->vAddNewChild();

    staticTree1.pcGetRoot()->pcGetChild(0)->vSetValue(1);
    staticTree1.pcGetRoot()->pcGetChild(1)->vSetValue(2);
    staticTree1.pcGetRoot()->pcGetChild(2)->vSetValue(3);

    staticTree1.pcGetRoot()->pcGetChild(2)->vAddNewChild();
    staticTree1.pcGetRoot()->pcGetChild(2)->vAddNewChild();
    staticTree1.pcGetRoot()->pcGetChild(2)->vAddNewChild();
    staticTree1.pcGetRoot()->pcGetChild(2)->pcGetChild(0)->vSetValue(4);
    staticTree1.pcGetRoot()->pcGetChild(2)->pcGetChild(1)->vSetValue(5);
    staticTree1.pcGetRoot()->pcGetChild(2)->pcGetChild(2)->vSetValue(6);

    staticTree1.pcGetRoot()->pcGetChild(2)->pcGetChild(2)->vAddNewChild();
    staticTree1.pcGetRoot()->pcGetChild(2)->pcGetChild(2)->pcGetChild(0)->vSetValue(7);
    //Second TreeStatic
      /*
      30
     /     50
    /    /
    0 - 20 - 40 -70
     \   \
      \   60
       10
       */
    CTreeStatic staticTree2;

    staticTree2.pcGetRoot()->vSetValue(0);

    staticTree2.pcGetRoot()->vAddNewChild();
    staticTree2.pcGetRoot()->vAddNewChild();
    staticTree2.pcGetRoot()->vAddNewChild();

    staticTree2.pcGetRoot()->pcGetChild(0)->vSetValue(10);
    staticTree2.pcGetRoot()->pcGetChild(1)->vSetValue(20);
    staticTree2.pcGetRoot()->pcGetChild(2)->vSetValue(30);
              
    staticTree2.pcGetRoot()->pcGetChild(2)->vAddNewChild();
    staticTree2.pcGetRoot()->pcGetChild(2)->vAddNewChild();
    staticTree2.pcGetRoot()->pcGetChild(2)->vAddNewChild();
    staticTree2.pcGetRoot()->pcGetChild(2)->pcGetChild(0)->vSetValue(40);
    staticTree2.pcGetRoot()->pcGetChild(2)->pcGetChild(1)->vSetValue(50);
    staticTree2.pcGetRoot()->pcGetChild(2)->pcGetChild(2)->vSetValue(60);
              
    staticTree2.pcGetRoot()->pcGetChild(2)->pcGetChild(2)->vAddNewChild();
    staticTree2.pcGetRoot()->pcGetChild(2)->pcGetChild(2)->pcGetChild(0)->vSetValue(70);
    
    cout << "CTreeStatic #1: " << endl;
    staticTree1.vPrintFullTree();

    cout << "\nCTreeStatic #2 " << endl;
    staticTree2.vPrintFullTree();

    staticTree1.bMoveSubtree(staticTree1.pcGetRoot()->pcGetChild(0), staticTree2.pcGetRoot()->pcGetChild(2));

    cout << "\nCTreeStatic #1 bMoveSubtree " << endl;
    staticTree1.vPrintFullTree();

    cout << "\nCTreeStatic #2 bMoveSubtree  " << endl;
    staticTree2.vPrintFullTree();

    //First TreeDynamic
    /*
    *  
    0 - 2 - 3
     \
      \
       1 - 4
    */
    CTreeDynamic<int> dynamicTree1;

    dynamicTree1.pcGetRoot()->vSetValue(0);

    dynamicTree1.pcGetRoot()->vAddNewChild();
    dynamicTree1.pcGetRoot()->vAddNewChild();
    dynamicTree1.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(1);
    dynamicTree1.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vSetValue(2);

    dynamicTree1.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vAddNewChild();
    dynamicTree1.pcGetRoot()->pcGetChild(1)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(3);

    dynamicTree1.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vAddNewChild();
    dynamicTree1.pcGetRoot()->pcGetChild(0)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(4);

    //Second TreeDynamic
    /*
    *
    0 - 20 - 30
     \
      \
       10 - 40
    */

    CTreeDynamic<int> dynamicTree2;
    dynamicTree2.pcGetRoot()->vSetValue(0);

    dynamicTree2.pcGetRoot()->vAddNewChild();
    dynamicTree2.pcGetRoot()->vAddNewChild();
    dynamicTree2.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(10);
    dynamicTree2.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vSetValue(20);

    dynamicTree2.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vAddNewChild();
    dynamicTree2.pcGetRoot()->pcGetChild(1)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(30);

    dynamicTree2.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vAddNewChild();
    dynamicTree2.pcGetRoot()->pcGetChild(0)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(40);

   


    cout << "\nCTreeDynamic #1 " << endl;
    dynamicTree1.vPrintFullTree();

    cout << "\nCTreeDynamic #2 " << endl;
    dynamicTree2.vPrintFullTree();

    dynamicTree1.bMoveSubtree(dynamicTree1.pcGetRoot()->pcGetChild(0)->pcGetRoot(), dynamicTree2.pcGetRoot()->pcGetChild(1)->pcGetRoot());

    cout << "\nCTreeStatic #1 bMoveSubtree " << endl;
    dynamicTree1.vPrintFullTree();

    cout << "\nCTreeDynamic #2 bMoveSubtree " << endl;
    dynamicTree2.vPrintFullTree();
    cout << "\n\n\nTest mod:" << endl;
    CTreeDynamic<double> dynamicTreeTest1;
    /*
    *
    0 - 2 -1
     \
      \
       1 - 1
    */
    dynamicTreeTest1.pcGetRoot()->vSetValue(2.3);
                   
    dynamicTreeTest1.pcGetRoot()->vAddNewChild();
    dynamicTreeTest1.pcGetRoot()->vAddNewChild();
    dynamicTreeTest1.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(2.2);
    dynamicTreeTest1.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vSetValue(2.2);
                   
    dynamicTreeTest1.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vAddNewChild();
    dynamicTreeTest1.pcGetRoot()->pcGetChild(1)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(2.2);
                   
    dynamicTreeTest1.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vAddNewChild();
    dynamicTreeTest1.pcGetRoot()->pcGetChild(0)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(2.2);
    cout << "\n\n\n\n" << endl;
    dynamicTreeTest1.vPrintFullTree();
    cout << "\n" << dynamicTreeTest1.iCount(2.2) << endl;
    

    CTreeDynamic<string> dynamicTreeTest2;
    /*
    *
    0 - 2 -1
     \
      \
       1 - 1
    */
    dynamicTreeTest2.pcGetRoot()->vSetValue("a");

    dynamicTreeTest2.pcGetRoot()->vAddNewChild();
    dynamicTreeTest2.pcGetRoot()->vAddNewChild();
    dynamicTreeTest2.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue("a");
    dynamicTreeTest2.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vSetValue("b");

    dynamicTreeTest2.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vAddNewChild();
    dynamicTreeTest2.pcGetRoot()->pcGetChild(1)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue("c");

    dynamicTreeTest2.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vAddNewChild();
    dynamicTreeTest2.pcGetRoot()->pcGetChild(0)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue("d");
    cout << "\n\n\n\n" << endl;
    dynamicTreeTest2.vPrintFullTree();
    cout << "\n" << dynamicTreeTest2.iCount("a") << endl;


}


