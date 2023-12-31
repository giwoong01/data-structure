# [자바와 함께하는 자료구조의 이해]

---

## 목차

- [PART2 - 리스트](#part2---리스트)
- [PART3 - 스택과 큐](#part3---스택과-큐)
- [PART4 - 트리](#part4---트리)

---

## PART2 - 리스트

- 리스트는 일련의 동일한 타입의 항목들이 나열된 것이다.


- 리스트의 구현 :
    - [배열](#배열)
    - [단순 연결 리스트](#단순-연결-리스트)
    - [이중 연결 리스트](#이중-연결-리스트)
    - [원형 연결 리스트](#원형-연결-리스트)

### 배열

- 동일한 타입의 원소들이 연속적인 메모리 공간에 할당되어 각 항목이 하나의 원소에 저장되는 기본적인 자료구조이다.
- 특정 원소에 접근할 때에는 배열의 인덱스로 O(1)시간에 접근한다.
- 새 항목을 배열 중간에 삽입하거나 중간에 있는 항목을 삭제하면, 뒤 따르는 항목들을 1칸씩 뒤로 또는 앞으로 이동해야 하므로 O(n)시간이다.
- Overflow
    - 미리 정해진 크기의 메모리 공간을 할당 받은 뒤 사용해야하므로, 빈자리가 없어 새 항목을 삽입할 수 없는 상황이다.

### 단순 연결 리스트

- 동적 메모리 할당을 이용해 리스트를 구현하는 가장 간단한 형태의 자료구조이다.
- 동적 메모리 할당을 받아 노드를 저장하고, 노드는 레퍼런스를 이용하여 다음 노드를 가리키도록 만들어 노드들을 한줄로 연결한다.
- 연결 리스트에서는 삽입이나 삭제 시 다른 노드들의 이동이 필요 없다.
- 단순 연결 리스트는 삽입이나 삭제할 때 반드시 이전 노드를 가리키는 레퍼런스를 추가로 알아내야 하고, 역방향으로 노드들을 탐색할 수 없다.
- 배열의 경우 최초에 배열의 크기를 예측하여 결정해야 하므로 대부분의 경우 배열에 빈 공간이 있으나, 연결 리스트는 빈 공간이 없다.
- 연결 리스트에서는 탐색하려면 항상 첫 노드부터 원하는 노드까지 차례로 방문한다 -> 순차 탐색

### 이중 연결 리스트

- 각 노드가 두개의 레퍼런스를 가지고 각각 이전 노드와 다음 노드를가리키는 연결리스트이다.
- 이중 연결 리스트는 단순 연결 리스트의 단점을 보완하지만, 각 노드마다 추가로 한 개의 레퍼런스를 추가로 저장해야 한다는 단점을 가진다.

### 원형 연결 리스트

- 마지막 노드가 첫 노드와 연결된 단순 연결 리스트이다.
- 마지막 노드의 레퍼런스가 저장된 last가 단순 연결 리스트의 head와 같은 역할이다.
- 마지막 노드와 첫 노드를 O(1)시간에 방문할 수 있는 장점이 있다.
- 리스트가 empty가 아니면 어떤 노드도 null 레퍼런스를 가지고 있지 않으므로 프로그램에서 null 조건을 검사하지 않아도 되는 장점이 있다.
- 반대 방향으로 노드들을 방문하기 쉽지 않으며, 무한 루프가 발생할 수 있음에 유의할 필요가 있다.

|   자료구조    |  접근  |  탐색  |  삽입  |  삭제  |
|:---------:|:----:|:----:|:----:|:----:|
|  1차원 배열   | O(1) | O(n) | O(n) | O(n) |
| 단순 연결 리스트 | O(n) | O(n) | O(1) | O(1) | 
| 이중 연결 리스트 | O(n) | O(n) | O(1) | O(1) |
| 원형 연결 리스트 | O(n) | O(n) | O(1) | O(1) |

- 비고 :
    - 1차원 배열 - 정렬된 배열에서 탐색은 O(logn)
    - 연결 리스트 - 삽입 또는 삭제할 노드의 이전 노드의 레퍼런스가 주어진 경우

---

## PART3 - 스택과 큐

### 스택(Stack)

- 한쪽 끝에서만 항목 삽입/삭제나는 자료구조
- 새 항목을 저장하는 연산 : push
- Top 항목을 삭제하는 연산 : pop
- 후입선출(Last-In First-Out, LIFO)
- 배열과 단순 연결 리스트로 스택을 구현할 수 있다.

### 스택의 응용

- 컴파일러의 괄호 짝 맞추기, 회문 검사하기, 후위 표기법 수식 계산하기, 중위 표기법 수식을 후위 표기법으로 변환하기, 미로찾기, 트리의 순회, 그래프의 깊이 우선 탐색에 사용된다.
- 프로그래밍에서 매우 중요한 메소드 호출 및 순환 호출도 스택 자료구조를 바탕으로 구현된다.

### 수식의 표기법

- 프로그램을 작성할 때 수식에서 +, -, *, / 와 같은 이항연산자는 2개의 피연산자들 사이에 위치
- 이러한 방식의 수식 표현이 중위표기법 (Infix Notation)
- 컴파일러는 중위표기법 수식을 후위표기법 (Postfix Notation)으로 바꾼다.
    - 그 이유는 후위표기법 수식은 괄호 없이 중위 표기법 수식을 표현할 수 있기 때문이다.
- 전위 표기법(Prefix Notation) : 연산자를 피연산자들 앞에 두는 표기법

|       중위표기        |     후위표기      |     전위표기      |
|:-----------------:|:-------------:|:-------------:|
|       A + B       |     A B +     |     + A B     |
|     A + B - C     |   A B + C -   |   + A - B C   |
|   A + B * C - D   | A B C * + D - | - + A * B C D |
| (A + B) / (C - D) | A B + C D - / | / + A B - C D |

### 중위 표기 수식을 후위 표기로 변환

[핵심 아이디어] 왼쪽 괄호나 연산자는 스택에 push하고, 피연산자는 출력

- 입력을 좌에서 우로 문자를 1개씩 읽는다. 읽은 문자가
    1. 피연산자이면, 읽은 문자를 출력
    2. 왼쪽 괄호이면, push
    3. 오른쪽 괄호이면, 왼쪽 괄호가 나올 때까지 pop하여 출력. 단, 오른쪽이나 왼쪽 괄호는 출력하지 않는다.
    4. 연산자이면, 자신의 우선순위보다 낮은 연산자가 스택 top에 나타날 때까지 pop하여 출력하고 읽은 연산자를 push
- 입력을 모두 읽었으면 스택이 empty될 때 까지 pop출력

### 후위 표기 수식 계산

[핵심 아이디어] 피연산자는 스택에 push하고, 연산자는 2회 pop하여 계산한 후 push

- 입력을 좌에서 우로 문자를 1개씩 읽고 이를 c라고 하면
    1. c가 피연산자이면 c를 push
    2. c가 연산자(op)이면 pop를 2회 수행한다. 먼저 pop된 피연산자가 A이고, 나중에 pop된 피연산자가 B라면, (A op B)를 수행하여 그 결괏값을 push

### 큐(Queue)

- 삽입과 삭제가 양 끝에서 각각 수행되는 자료구조
- 일상생활의 관공서, 은행, 우체국, 병원 등에서 번호표를 이용한 줄서기
- 선입 선출(First-In Fisrt-Out, FIFO)


- 배열로 구현된 큐에서 삽입과 삭제를 거듭하게 되면 큐의 항목이 오른쪽으로 편중되는 문제가 발생한다. 이를 해결하는 방법은 배열을 원형으로, 즉, 배열의 마지막 원소가 첫 원소와 맞닿아 있는 개념으로 구현한다.
- 큐는 CPU의 태스크 스케줄링, 네트워크 프린터, 실시간 시스템의 인터럽트 처리, 다양한 이벤트 구동 방식 컴퓨터 시뮬레이션, 콜 센터의 전화 서비스 처리 등에 사용되며, 이진 트리의 레벨 순회와 그래프의 너비
  우선 탐색에 사용된다.

### 데크(Double-ended Queue, Deque)

- 양쪽 끝에서 삽입과 삭제를 허용하는 자료구조
- 스택과 큐 자료구조를 혼합한 자료구조
- 테크는 스택과 큐를 동시에 구현하는데 사용

### 데크의 응용

- 스크롤(Scroll)
- 문서 편집기 등의 undo 연산
- 웹 브라우저의 방문 기록 등

|      자료구조       |   구현   |  삽입  |  삭제  |        비고         |
|:---------------:|:------:|:----:|:----:|:-----------------:|
| 스택<br/>큐<br/>데크 |   배열   | O(1) | O(1) |     상간분석 평균시간     |
|       ``        | 연결 리스트 | O(1) | O(1) | 데크는 이중 연결 리스트로 구현 |

---

## PART4 - 트리

### 트리

- 배열이나 연결 리스트 : 데이터를 일렬로 저장하므로 탐색을 순차적으로 수행
- 정렬된 배열에서는 이진 탐색을 통해 효율적인 탐색이 가능하지만, 삽입/삭제 후 정렬 상태 유지 때문에 O(n)시간
- 일반적인 트리(General Tree)는 실제 트리를 거꾸로 세워 놓은 형태의 자료구조
    - 트리는 empty이거나, empty가 아니면 루트노드 R과 트리의 집합으로 구성되는데 각 트리의 루트노드는 R의 자식노드이다. 단, 트리의 집합은 공집합 일 수도 있다.

### 응용

- 조직이나 기관의 계층구조
- 컴퓨터 운영체제의 파일 시스템
- 자바 클래스 계층구조
- 다양한 탐색 트리(Search Tree)
- 힙(Heap) 자료구조
- 컴파일러의 수식을 위한 구문 트리(Syntax Tree) 등

---

| 용어                   | 설명                             |
|----------------------|--------------------------------|
| 루트(Root)             | 트리의 최상위에 있는 노드                 |
| 자식(Child)            | 노드 하위에 연결된 노드                  |
| 차수(Degree)           | 자식 수                           |
| 부모(Parent)           | 노드의 상위에 연결된 노드                 |
| 이파리(Leaf)            | 자식이 없는 노드                      |
| 형제(Sibling)          | 동일한 부모를 가지는 노드                 |
| 조상(Ancestor)         | 루트까지의 경로상에 있는 모든 노드            |
| 후손(Descendant)       | 노드 아래로 매달린 모든 노드들의 집합          |
| 서브트리(Subtree)        | 노드 자신과 후손으로 구성된 트리             |
| 레벨(Level), 깊이(Depth) | 루트는 레벨 1, 아래 층으로 내려가며 레벨 1씩 증가 |
| 높이(Height)           | 트리의 최대 레벨                      |
| 키(Key)               | 탐색에 사용되는 노드에 저장된 정보            |

---

- 이파리 노드 : 단말(Terminal)노드 또는 외부(External)노드
- 내부(Internal) 노드 또는 비 단말(Non-Terminal) 노드: 이파리가 아닌 노드
- 일반적인 트리를 메모리에 저장하려면 각 노드에 키와 자식 수 만큼의 레퍼런스 저장 필요

---

- N개의 노드가 있는 최대 차수가 k인 트리
    - null 레퍼런스 수 = Nk - (N-1) = N(k-1) + 1
    - nk = 총 레퍼런스의 수
    - (N-1) = 트리에서 부모 - 자식을 연결하는 레퍼런스 수
- k가 클수록 메모리의 낭비가 심해지는 것은 물론, 트리를 탐색하는 과정에서 null 레퍼런스를 확인해야 하므로 시간적으로도 매우 비효율적

---

### 왼쪽자식-오른쪽형제(Left Child-Right Sibling) 표현

- 노드의 왼쪽 자식과 왼쪽 자식의 오른쪽 형제노드를 가리키는 2개의 레퍼런스만을 사용

### 이진 트리(Binary Tree)

- 각 노드의 자식 수가 2 이하인 트리
- 컴퓨터 분야에서 널리 활용되는 기본적인 자료구조
- 데이터의 구조적인 관계를 잘 반영
- 효율적인 삽입과 탐색 가능
- 이진 트리의 서브트리를 다른 이진 트리의 서브트리와 교환하는 것이 쉽다.
- 이진 트리에 대한 용어는 일반적인 트리에 대한 용어와 동일.

구성

- empty트리,
- 루트만 있는 이진 트리,
- 루트의 오른쪽 서브트리가 없는(empty) 이진트리,
- 루트의 왼쪽 서브트리가 없는 이진 트리

### 특별한 형태의 이진 트리

- 포화 이진 트리(Perfect Binary Tree) : 각 내부 노드가 2개의 자식을 가지고 모든 이파리가 같은 층에 있는 트리
- 완전 이진 트리(Complete Binary Tree) : 마지막 레벨을 제외한 각 레벨이 노드들로 꽉 차있고, 마지막 레벨에는 노드들이 왼쪽부터 빠짐없이 채워진 트리
    - 포화 이진 트리는 완전 이진 트리이다.

### 이진 트리의 속성

- 레벨 k에 있는 최대 노드의 수 = 2^(k-1), k = 1, 2, 3, ...
- 높이가 h인 포화 이진 트리에 있는 노드 수 = 2^h - 1
- N개의 노드를 가진 완전 이진 트리의 높이 = log2(N+1) -> 올림
- 높이가 h인 완전 이진 트리에 존재 할 수 있는 최대 노드 수 = 2^(h-1) ~ 2^h - 1

### 편향 이진 트리

- 편향(Skewed) 이진 트리를 배열에 저장하는 경우, 트리의 높이가 커질 수록 메모리 낭비가 심화됨.

--- 

### 이진 트리의 연산

- 이진 트리에서 수행되는 기본 연산들은 트리를 순회(Traversal)하며 이루어 진다.
- 전위 순회(Preorder Traversal)
    - VLR
- 중위 순회(Inorder Traversal)
    - LVR
- 후위 순회(Postorder Traversal)
    - LRV
- 레벨 순회(Levelorder Traversal)
    - 최상위 레벨부터 시작하여 각 레벨마다 좌에서 우로 노드들을 방문

- size() : 트리의 노드 수 계산
- height() : 트리의 높이 계산
- isEqual() : 2개의 이진트리에 대한 동일성 검사
- size()와 height()는 후위순회에 기반하고, isEqual()은 전위순회에 기반

### 스레드 이진트리

- 이진트리의 기본 연산들은 레벨순회를 제외하고 모두 스택 자료구조를 사용
- 메소드의 재귀호출은 시스템 스택을 사용하므로 스택 자료구조를 사용한 것으로 간주
- 스택에 사용되는 메모리 공간의 크기는 트리의 높이에 비례
- 스레드는 운영체제에서 스케줄러가 운영하는 독립적인 수행 단위인 스레드와는 전혀 관계 없는 단어
- n개의 노드가 있는 이진 트리의 null 레퍼런스 필드 수 = (n + 1)
- 총 2n개의 레퍼런스 필드 중에서 부모 자식을 연결하는 레퍼런스는 n - 1개

#### 스레드 이진 트리 : n + 1개의 null 레퍼런스를 활용하여, 이전에 방문한 노드와 다음에 방문할 노드를 가리키도록 만들어 순회 연산이 스택 없이도 수행될 수 있도록 만든 트리

- 스레드 이진트리는 대부분의 경우 중위순회에 기반하여 구현되나, 전위순회이나 후위순회에 기반하여 스레드 트리를 구현할 수도 있음
- 스레드 이진트리는 스택을 사용하는 순회보다 빠르고 메모리 공간도 적게 차지한다는 장점을 갖지만 데이터의 삽입과삭제가잦은경우그구현이비교적복잡한편이므로 좋은 성능을 보여주지 못한다는 문제점
- Node 객체에 2개의 boolean 필드를 사용하여 레퍼런스가 스레드(다음 방문할 노드를 가리키는)로 사용되는 것인지 아니면 left나 right가 트리의 부모 자식 사이의 레퍼런스인지를 각각 true 와
  false로 표시해주어야 함

