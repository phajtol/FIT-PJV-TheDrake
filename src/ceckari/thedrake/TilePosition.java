package ceckari.thedrake;


/**
 *
 * @author friedtad & hajtopet
 */
public class TilePosition {

	/**
	 *
	 */
	public final int i;
	public final int j;


	/**
	 *
	 * @param i
	 * @param j
	 */
	public TilePosition(int i, int j)
	{
		this.i = i;
		this.j = j;
	}


	/**
	 *
	 * @param column
	 * @param row
	 */
	public TilePosition(char column, int row)
	{
		this.i = iFromColumn(column);
		this.j = jFromRow(row);
	}


	/**
	 *
	 * @param pos
	 */
	public TilePosition(String pos)
	{
		this(pos.charAt(0), Integer.parseInt(pos.substring(1)));
	}


	/**
	 *
	 * @return
	 */
	public char column()
	{
		return (char) ('a' + i);
	}


	/**
	 *
	 * @return
	 */
	public int row()
	{
		return j + 1;
	}


	/**
	 *
	 */
	public TilePosition step(int columnStep, int rowStep)
	{
		return new TilePosition(i + columnStep, j + rowStep);
	}


	/**
	 *
	 * @param step
	 * @return
	 */
	public TilePosition step(Offset2D step)
	{
		return step(step.x, step.y);
	}


	/**
	 *
	 * @param pos
	 * @return
	 */
	public boolean isNextTo(TilePosition pos)
	{
		if(this.i == pos.i && Math.abs(this.j - pos.j) == 1)
			return true;
		
		if(this.j == pos.j && Math.abs(this.i - pos.i) == 1)
			return true;
		
		return false;
	}


	/**
	 *
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean equalsTo(int i, int j)
	{
		return this.i == i && this.j == j;
	}


	/**
	 *
	 * @param column
	 * @param row
	 * @return
	 */
	public boolean equalsTo(char column, int row)
	{
		return this.i == iFromColumn(column) && this.j == jFromRow(row);
	}


	/**
	 *
	 * @param column
	 * @return
	 */
	private int iFromColumn(char column)
	{
		return column - 'a';
	}


	/**
	 *
	 * @param row
	 * @return
	 */
	private int jFromRow(int row)
	{
		return row - 1;
	}


	/**
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		return String.format("%c%d", column(), row());
	}
}
