import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static List<Room> rooms = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //인원수
		M = Integer.parseInt(st.nextToken()); //레벨
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int lv = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			entry(new Player(lv,name));
		}

		printRooms();
	}

	private static void entry(Player player){
		for (Room room: rooms){
			if (!room.isFull()&&player.lv>=room.lowerLv&&player.lv<=room.upperLv){
				room.addPlayer(player);
				return;
			}
		}
		rooms.add(new Room(player, M));
	}

	private static void printRooms(){
		for (Room room: rooms){
			sb.append(room.getStatus()).append("\n");
			Collections.sort(room.players);
			for (Player player:room.players){
				sb.append(player.lv).append(" ").append(player.name).append("\n");
			}
		}
		System.out.print(sb);
	}
}

class Player implements Comparable<Player>{
	int lv;
	String name;

	public Player(int lv, String name) {
		this.lv = lv;
		this.name = name;
	}

	public int compareTo(Player player){
		return this.name.compareTo(player.name);
	}
}

class Room{
	int lowerLv;
	int upperLv;
	int limitPlayersCnt;
	List<Player> players = new ArrayList<>();

	public Room(Player firstPlayer, int limitPlayersCnt) {
		this.lowerLv = firstPlayer.lv-10;
		this.upperLv = firstPlayer.lv+10;
		this.limitPlayersCnt = limitPlayersCnt;
		addPlayer(firstPlayer);
	}

	public String getStatus(){
		if (isFull()) return "Started!";
		else return "Waiting!";
	}

	public boolean isFull(){
		return players.size()==limitPlayersCnt;
	}

	public void addPlayer(Player player){
		this.players.add(player);
	}
}
//return this.name.charAt(0) - o.name.charAt(0);