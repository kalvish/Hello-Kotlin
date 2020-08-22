package example.myapp

class Plecostomus(fishAction: FishAction = PrintingFishAction("Eat algae"),
                  fishColor: FishColor = GoldColor) : FishAction by fishAction, FishColor by fishColor