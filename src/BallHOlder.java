class BallHOlder {

    Ball ballToHold;

    /*
        Force developers to use builder, dont use these old school constructor things
     */
    private BallHOlder(Ball ballToHold) {
        this.ballToHold = ballToHold;
    }

    static class BallHOlderBuilder {
        Ball ballInsideBuilder;
        private BallHOlderBuilder() {/* dont' let peeps create one, they must call static methods */}
        static BallHOlderBuilder startBuilding() {
            return new BallHOlderBuilder();
        }

        BallHOlderBuilder includeThisBallInsideTheBuilder(Ball ballToHold) {
           this.ballInsideBuilder = ballToHold;
           return this;
        }

        BallHOlder build() {
            return new BallHOlder(ballInsideBuilder);
        }
    }
}