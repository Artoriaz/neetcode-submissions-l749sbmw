class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair<Integer,Integer>> cars = new ArrayList<>();
        for(int i = 0; i< position.length; i++) {
            cars.add(new Pair<>(position[i], speed[i]));
        }

        cars.sort((a, b) -> Integer.compare(b.getPosition(), a.getPosition()));
        Stack<Double> stack = new Stack<>();

        for(Pair<Integer,Integer> p: cars){
            stack.push((double) (target - p.getPosition()) / p.getSpeed());
            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
    }
    private static class Pair<K,V> {
        private final K position;
        private final V speed;
        Pair(K position, V speed) {
            this.position = position;
            this.speed = speed;
        }
        public K getPosition() {
            return position;
        }
          public V getSpeed() {
            return speed;
        }
        
    }
}
