public class GomokuAgent 
{
		GomokuClient gc;
		char[][] GomokuBoard;

		public GomokuAgent()
		{
			gc = new GomokuClient("localhost", 17033);
		}
		/*private String think(SensoryPacket sp)
		{
			
		}*/
		public void run()
		{
			while(true)
			{
				try
				{
					String board = gc.boardIn.readLine().toString();
				}
				catch(Exception e)
				{
					System.exit(1);
				}
				//gc.effectorSend(action);
			}
		}
		public static void main(String[] args)
		{
			GomokuAgent ga = new GomokuAgent();
			ga.run();
		}
}
