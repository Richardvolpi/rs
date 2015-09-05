import java.io.IOException;

public class World {

    public int getWallEastwest(int x, int y) {
        if (x < 0 || x >= 96 || y < 0 || y >= 96)
            return 0;
        byte h = 0;
        if (x >= 48 && y < 48) {
            h = 1;
            x -= 48;
        } else if (x < 48 && y >= 48) {
            h = 2;
            y -= 48;
        } else if (x >= 48 && y >= 48) {
            h = 3;
            x -= 48;
            y -= 48;
        }
        return wallsEastwest[h][x * 48 + y] & 0xff;
    }

    public void method396(int i, int j, int k, int l, int i1) {
        GameModel gameModel = aGameModelArray599[i + j * 8];
        for (int j1 = 0; j1 < gameModel.numVertices; j1++)
            if (gameModel.vertexX[j1] == k * 128 && gameModel.vertexZ[j1] == l * 128) {
                gameModel.setVertexAmbience(j1, i1);
                return;
            }

    }

    public int getWallRoof(int x, int y) {
        if (x < 0 || x >= 96 || y < 0 || y >= 96)
            return 0;
        byte h = 0;
        if (x >= 48 && y < 48) {
            h = 1;
            x -= 48;
        } else if (x < 48 && y >= 48) {
            h = 2;
            y -= 48;
        } else if (x >= 48 && y >= 48) {
            h = 3;
            x -= 48;
            y -= 48;
        }
        return wallsRoof[h][x * 48 + y];
    }

    public int getElevation(int x, int y) {
        int sX = x >> 7;
        int sY = y >> 7;
        int aX = x & 0x7f;
        int aY = y & 0x7f;
        if (sX < 0 || sY < 0 || sX >= 95 || sY >= 95)
            return 0;
        int h;
        int hx;
        int hy;
        if (aX <= 128 - aY) {
            h = getTerrainHeight(sX, sY);
            hx = getTerrainHeight(sX + 1, sY) - h;
            hy = getTerrainHeight(sX, sY + 1) - h;
        } else {
            h = getTerrainHeight(sX + 1, sY + 1);
            hx = getTerrainHeight(sX, sY + 1) - h;
            hy = getTerrainHeight(sX + 1, sY) - h;
            aX = 128 - aX;
            aY = 128 - aY;
        }
        int elevation = h + (hx * aX) / 128 + (hy * aY) / 128;
        return elevation;
    }

    public int getWallDiagonal(int x, int y) {
        if (x < 0 || x >= 96 || y < 0 || y >= 96)
            return 0;
        byte h = 0;
        if (x >= 48 && y < 48) {
            h = 1;
            x -= 48;
        } else if (x < 48 && y >= 48) {
            h = 2;
            y -= 48;
        } else if (x >= 48 && y >= 48) {
            h = 3;
            x -= 48;
            y -= 48;
        }
        return wallsDiagonal[h][x * 48 + y];
    }

    public void method400(int i, int j, int k) {
        if (i < 0 || j < 0 || i >= 95 || j >= 95)
            return;
        if (GameData.objectType[k] == 1 || GameData.objectType[k] == 2) {
            int l = getTileDirection(i, j);
            int i1;
            int j1;
            if (l == 0 || l == 4) {
                i1 = GameData.objectWidth[k];
                j1 = GameData.objectHeight[k];
            } else {
                j1 = GameData.objectWidth[k];
                i1 = GameData.objectHeight[k];
            }
            for (int k1 = i; k1 < i + i1; k1++) {
                for (int l1 = j; l1 < j + j1; l1++)
                    if (GameData.objectType[k] == 1)
                        objectAdjacency[k1][l1] |= 0x40;
                    else if (l == 0) {
                        objectAdjacency[k1][l1] |= 2;
                        if (k1 > 0)
                            method419(k1 - 1, l1, 8);
                    } else if (l == 2) {
                        objectAdjacency[k1][l1] |= 4;
                        if (l1 < 95)
                            method419(k1, l1 + 1, 1);
                    } else if (l == 4) {
                        objectAdjacency[k1][l1] |= 8;
                        if (k1 < 95)
                            method419(k1 + 1, l1, 2);
                    } else if (l == 6) {
                        objectAdjacency[k1][l1] |= 1;
                        if (l1 > 0)
                            method419(k1, l1 - 1, 4);
                    }

            }

            method404(i, j, i1, j1);
        }
    }

    public void removeWallObject(int i, int j, int k, int l) {
        if (i < 0 || j < 0 || i >= 95 || j >= 95)
            return;
        if (GameData.wallObjectVisible[l] == 1) {
            if (k == 0) {
                objectAdjacency[i][j] &= 0xfffe;
                if (j > 0)
                    method407(i, j - 1, 4);
            } else if (k == 1) {
                objectAdjacency[i][j] &= 0xfffd;
                if (i > 0)
                    method407(i - 1, j, 8);
            } else if (k == 2)
                objectAdjacency[i][j] &= 0xffef;
            else if (k == 3)
                objectAdjacency[i][j] &= 0xffdf;
            method404(i, j, 1, 1);
        }
    }

    public void method402(int i, int j, int k, int l, int i1) {
        int j1 = i * 3;
        int k1 = j * 3;
        int l1 = scene.method302(l);
        int i2 = scene.method302(i1);
        l1 = l1 >> 1 & 0x7f7f7f;
        i2 = i2 >> 1 & 0x7f7f7f;
        if (k == 0) {
            surface.drawLineHoriz(j1, k1, 3, l1);
            surface.drawLineHoriz(j1, k1 + 1, 2, l1);
            surface.drawLineHoriz(j1, k1 + 2, 1, l1);
            surface.drawLineHoriz(j1 + 2, k1 + 1, 1, i2);
            surface.drawLineHoriz(j1 + 1, k1 + 2, 2, i2);
            return;
        }
        if (k == 1) {
            surface.drawLineHoriz(j1, k1, 3, i2);
            surface.drawLineHoriz(j1 + 1, k1 + 1, 2, i2);
            surface.drawLineHoriz(j1 + 2, k1 + 2, 1, i2);
            surface.drawLineHoriz(j1, k1 + 1, 1, l1);
            surface.drawLineHoriz(j1, k1 + 2, 2, l1);
        }
    }

    public void loadSection(int x, int y, int plane, int chunk) {
        String mapname = "m" + plane + x / 10 + x % 10 + y / 10 + y % 10;
        int i1;
        try {
            if (landscapePack != null) {
                byte buff[] = Utility.loadData(mapname + ".hei", 0, landscapePack);
                if (buff == null && memberLandscapePack != null)
                    buff = Utility.loadData(mapname + ".hei", 0, memberLandscapePack);
                if (buff != null && buff.length > 0) {
                    int caret = 0;
                    int lastVal = 0;
                    for (int tile = 0; tile < 2304; ) {
                        int val = buff[caret++] & 0xff;
                        if (val < 128) {
                            terrainHeight[chunk][tile++] = (byte) val;
                            lastVal = val;
                        }
                        if (val >= 128) {
                            for (int i5 = 0; i5 < val - 128; i5++)
                                terrainHeight[chunk][tile++] = (byte) lastVal;

                        }
                    }

                    lastVal = 64;
                    for (int tileY = 0; tileY < 48; tileY++) {
                        for (int tileX = 0; tileX < 48; tileX++) {
                            lastVal = terrainHeight[chunk][tileX * 48 + tileY] + lastVal & 0x7f;
                            terrainHeight[chunk][tileX * 48 + tileY] = (byte) (lastVal * 2);
                        }

                    }

                    lastVal = 0;
                    for (int tile = 0; tile < 2304; ) {
                        int val = buff[caret++] & 0xff;
                        if (val < 128) {
                            terrainColour[chunk][tile++] = (byte) val;
                            lastVal = val;
                        }
                        if (val >= 128) {
                            for (int k7 = 0; k7 < val - 128; k7++)
                                terrainColour[chunk][tile++] = (byte) lastVal;

                        }
                    }

                    lastVal = 35;
                    for (int tileY = 0; tileY < 48; tileY++) {
                        for (int tileX = 0; tileX < 48; tileX++) {
                            lastVal = terrainColour[chunk][tileX * 48 + tileY] + lastVal & 0x7f;// ??? wat
                            terrainColour[chunk][tileX * 48 + tileY] = (byte) (lastVal * 2);
                        }

                    }

                } else {
                    for (int tile = 0; tile < 2304; tile++) {
                        terrainHeight[chunk][tile] = 0;
                        terrainColour[chunk][tile] = 0;
                    }

                }
                buff = Utility.loadData(mapname + ".dat", 0, mapPack);
                if (buff == null && memberMapPack != null)
                    buff = Utility.loadData(mapname + ".dat", 0, memberMapPack);
                if (buff == null || buff.length == 0)
                    throw new IOException();
                int caret = 0;
                for (int tile = 0; tile < 2304; tile++)
                    wallsNorthsouth[chunk][tile] = buff[caret++];

                for (int tile = 0; tile < 2304; tile++)
                    wallsEastwest[chunk][tile] = buff[caret++];

                for (int tile = 0; tile < 2304; tile++)
                    wallsDiagonal[chunk][tile] = buff[caret++] & 0xff;

                for (int tile = 0; tile < 2304; tile++) {
                    int val = buff[caret++] & 0xff;
                    if (val > 0)
                        wallsDiagonal[chunk][tile] = val + 12000;// why??
                }

                for (int tile = 0; tile < 2304; ) {
                    int val = buff[caret++] & 0xff;
                    if (val < 128) {
                        wallsRoof[chunk][tile++] = (byte) val;
                    } else {
                        for (int l8 = 0; l8 < val - 128; l8++)
                            wallsRoof[chunk][tile++] = 0;

                    }
                }

                int j8 = 0;
                for (int i9 = 0; i9 < 2304; ) {
                    int k9 = buff[caret++] & 0xff;
                    if (k9 < 128) {
                        tileDecoration[chunk][i9++] = (byte) k9;
                        j8 = k9;
                    } else {
                        for (int j10 = 0; j10 < k9 - 128; j10++)
                            tileDecoration[chunk][i9++] = (byte) j8;

                    }
                }

                for (int l9 = 0; l9 < 2304; ) {
                    int k10 = buff[caret++] & 0xff;
                    if (k10 < 128) {
                        tileDirection[chunk][l9++] = (byte) k10;
                    } else {
                        for (int j11 = 0; j11 < k10 - 128; j11++)
                            tileDirection[chunk][l9++] = 0;

                    }
                }

                buff = Utility.loadData(mapname + ".loc", 0, mapPack);
                if (buff != null && buff.length > 0) {
                    int i2 = 0;
                    for (int l10 = 0; l10 < 2304; ) {
                        int k11 = buff[i2++] & 0xff;
                        if (k11 < 128)
                            wallsDiagonal[chunk][l10++] = k11 + 48000;
                        else
                            l10 += k11 - 128;
                    }

                    return;
                }
            } else {
                byte abyte1[] = new byte[20736];
                Utility.readFully("../gamedata/maps/" + mapname + ".jm", abyte1, 20736);
                int j2 = 0;
                int i3 = 0;
                for (int l3 = 0; l3 < 2304; l3++) {
                    j2 = j2 + abyte1[i3++] & 0xff;
                    terrainHeight[chunk][l3] = (byte) j2;
                }

                j2 = 0;
                for (int l4 = 0; l4 < 2304; l4++) {
                    j2 = j2 + abyte1[i3++] & 0xff;
                    terrainColour[chunk][l4] = (byte) j2;
                }

                for (int i6 = 0; i6 < 2304; i6++)
                    wallsNorthsouth[chunk][i6] = abyte1[i3++];

                for (int j7 = 0; j7 < 2304; j7++)
                    wallsEastwest[chunk][j7] = abyte1[i3++];

                for (int k8 = 0; k8 < 2304; k8++) {
                    wallsDiagonal[chunk][k8] = (abyte1[i3] & 0xff) * 256 + (abyte1[i3 + 1] & 0xff);
                    i3 += 2;
                }

                for (int j9 = 0; j9 < 2304; j9++)
                    wallsRoof[chunk][j9] = abyte1[i3++];

                for (int i10 = 0; i10 < 2304; i10++)
                    tileDecoration[chunk][i10] = abyte1[i3++];

                for (int i11 = 0; i11 < 2304; i11++)
                    tileDirection[chunk][i11] = abyte1[i3++];

            }
            return;
        } catch (IOException Ex) {
            i1 = 0;
        }
        for (; i1 < 2304; i1++) {
            terrainHeight[chunk][i1] = 0;
            terrainColour[chunk][i1] = 0;
            wallsNorthsouth[chunk][i1] = 0;
            wallsEastwest[chunk][i1] = 0;
            wallsDiagonal[chunk][i1] = 0;
            wallsRoof[chunk][i1] = 0;
            tileDecoration[chunk][i1] = 0;
            if (plane == 0)
                tileDecoration[chunk][i1] = -6;
            if (plane == 3)
                tileDecoration[chunk][i1] = 8;
            tileDirection[chunk][i1] = 0;
        }

    }

    public void method404(int x, int y, int k, int l) {
        if (x < 1 || y < 1 || x + k >= 96 || y + l >= 96)
            return;
        for (int xx = x; xx <= x + k; xx++) {
            for (int yy = y; yy <= y + l; yy++)
                if ((method405(xx, yy) & 0x63) != 0 || (method405(xx - 1, yy) & 0x59) != 0 || (method405(xx, yy - 1) & 0x56) != 0 || (method405(xx - 1, yy - 1) & 0x6c) != 0)
                    method425(xx, yy, 35);
                else
                    method425(xx, yy, 0);

        }

    }

    public int method405(int i, int j) {
        if (i < 0 || j < 0 || i >= 96 || j >= 96)
            return 0;
        else
            return objectAdjacency[i][j];
    }

    public boolean method406(int i, int j) {
        return getWallRoof(i, j) > 0 && getWallRoof(i - 1, j) > 0 && getWallRoof(i - 1, j - 1) > 0 && getWallRoof(i, j - 1) > 0;
    }

    public void method407(int i, int j, int k) {
        objectAdjacency[i][j] &= 65535 - k;
    }

    public int method408(int i, int j) {
        if (i < 0 || i >= 96 || j < 0 || j >= 96)
            return 0;
        byte byte0 = 0;
        if (i >= 48 && j < 48) {
            byte0 = 1;
            i -= 48;
        } else if (i < 48 && j >= 48) {
            byte0 = 2;
            j -= 48;
        } else if (i >= 48 && j >= 48) {
            byte0 = 3;
            i -= 48;
            j -= 48;
        }
        return terrainColour[byte0][i * 48 + j] & 0xff;
    }

    public void reset() {
        if (worldInitialised)
            scene.clear();
        for (int i = 0; i < 64; i++) {
            aGameModelArray599[i] = null;
            for (int j = 0; j < 4; j++)
                aGameModelArrayArray577[j][i] = null;

            for (int k = 0; k < 4; k++)
                aGameModelArrayArray583[k][i] = null;

        }

        System.gc();
    }

    public void setTiles() {
        for (int x = 0; x < 96; x++) {
            for (int y = 0; y < 96; y++)
                if (getTileDecoration(x, y, 0) == 250)
                    if (x == 47 && getTileDecoration(x + 1, y, 0) != 250 && getTileDecoration(x + 1, y, 0) != 2)
                        setTileDecoration(x, y, 9);
                    else if (y == 47 && getTileDecoration(x, y + 1, 0) != 250 && getTileDecoration(x, y + 1, 0) != 2)
                        setTileDecoration(x, y, 9);
                    else
                        setTileDecoration(x, y, 2);

        }

    }

    public int getWallNorthsouth(int x, int y) {
        if (x < 0 || x >= 96 || y < 0 || y >= 96)
            return 0;
        byte h = 0;
        if (x >= 48 && y < 48) {
            h = 1;
            x -= 48;
        } else if (x < 48 && y >= 48) {
            h = 2;
            y -= 48;
        } else if (x >= 48 && y >= 48) {
            h = 3;
            x -= 48;
            y -= 48;
        }
        return wallsNorthsouth[h][x * 48 + y] & 0xff;
    }

    public int getTileDirection(int x, int y) {
        if (x < 0 || x >= 96 || y < 0 || y >= 96)
            return 0;
        byte h = 0;
        if (x >= 48 && y < 48) {
            h = 1;
            x -= 48;
        } else if (x < 48 && y >= 48) {
            h = 2;
            y -= 48;
        } else if (x >= 48 && y >= 48) {
            h = 3;
            x -= 48;
            y -= 48;
        }
        return tileDirection[h][x * 48 + y];
    }

    public int getTileDecoration(int x, int y, int unused, int def) {
        int deco = getTileDecoration(x, y, unused);
        if (deco == 0)
            return def;
        else
            return GameData.anIntArray97[deco - 1];
    }

    public int getTileDecoration(int x, int y, int unused) {
        if (x < 0 || x >= 96 || y < 0 || y >= 96)
            return 0;
        byte h = 0;
        if (x >= 48 && y < 48) {
            h = 1;
            x -= 48;
        } else if (x < 48 && y >= 48) {
            h = 2;
            y -= 48;
        } else if (x >= 48 && y >= 48) {
            h = 3;
            x -= 48;
            y -= 48;
        }
        return tileDecoration[h][x * 48 + y] & 0xff;
    }

    public void setTileDecoration(int x, int y, int v) {
        if (x < 0 || x >= 96 || y < 0 || y >= 96)
            return;
        byte h = 0;
        if (x >= 48 && y < 48) {
            h = 1;
            x -= 48;
        } else if (x < 48 && y >= 48) {
            h = 2;
            y -= 48;
        } else if (x >= 48 && y >= 48) {
            h = 3;
            x -= 48;
            y -= 48;
        }
        tileDecoration[h][x * 48 + y] = (byte) v;
    }

    public int route(int startX, int startY, int endX1, int endY1, int endX2, int endY2, int routeX[], int routeY[], boolean objects) {
        for (int x = 0; x < 96; x++) {
            for (int y = 0; y < 96; y++)
                routeVia[x][y] = 0;

        }

        int writePtr = 0;
        int readPtr = 0;
        int x = startX;
        int y = startY;
        routeVia[startX][startY] = 99;
        routeX[writePtr] = startX;
        routeY[writePtr++] = startY;
        int size = routeX.length;
        boolean reached = false;
        while (readPtr != writePtr) {
            x = routeX[readPtr];
            y = routeY[readPtr];
            readPtr = (readPtr + 1) % size;
            if (x >= endX1 && x <= endX2 && y >= endY1 && y <= endY2) {
                reached = true;
                break;
            }
            if (objects) {
                if (x > 0 && x - 1 >= endX1 && x - 1 <= endX2 && y >= endY1 && y <= endY2 && (objectAdjacency[x - 1][y] & 8) == 0) {
                    reached = true;
                    break;
                }
                if (x < 95 && x + 1 >= endX1 && x + 1 <= endX2 && y >= endY1 && y <= endY2 && (objectAdjacency[x + 1][y] & 2) == 0) {
                    reached = true;
                    break;
                }
                if (y > 0 && x >= endX1 && x <= endX2 && y - 1 >= endY1 && y - 1 <= endY2 && (objectAdjacency[x][y - 1] & 4) == 0) {
                    reached = true;
                    break;
                }
                if (y < 95 && x >= endX1 && x <= endX2 && y + 1 >= endY1 && y + 1 <= endY2 && (objectAdjacency[x][y + 1] & 1) == 0) {
                    reached = true;
                    break;
                }
            }
            if (x > 0 && routeVia[x - 1][y] == 0 && (objectAdjacency[x - 1][y] & 0x78) == 0) {
                routeX[writePtr] = x - 1;
                routeY[writePtr] = y;
                writePtr = (writePtr + 1) % size;
                routeVia[x - 1][y] = 2;
            }
            if (x < 95 && routeVia[x + 1][y] == 0 && (objectAdjacency[x + 1][y] & 0x72) == 0) {
                routeX[writePtr] = x + 1;
                routeY[writePtr] = y;
                writePtr = (writePtr + 1) % size;
                routeVia[x + 1][y] = 8;
            }
            if (y > 0 && routeVia[x][y - 1] == 0 && (objectAdjacency[x][y - 1] & 0x74) == 0) {
                routeX[writePtr] = x;
                routeY[writePtr] = y - 1;
                writePtr = (writePtr + 1) % size;
                routeVia[x][y - 1] = 1;
            }
            if (y < 95 && routeVia[x][y + 1] == 0 && (objectAdjacency[x][y + 1] & 0x71) == 0) {
                routeX[writePtr] = x;
                routeY[writePtr] = y + 1;
                writePtr = (writePtr + 1) % size;
                routeVia[x][y + 1] = 4;
            }
            if (x > 0 && y > 0 && (objectAdjacency[x][y - 1] & 0x74) == 0 && (objectAdjacency[x - 1][y] & 0x78) == 0 && (objectAdjacency[x - 1][y - 1] & 0x7c) == 0 && routeVia[x - 1][y - 1] == 0) {
                routeX[writePtr] = x - 1;
                routeY[writePtr] = y - 1;
                writePtr = (writePtr + 1) % size;
                routeVia[x - 1][y - 1] = 3;
            }
            if (x < 95 && y > 0 && (objectAdjacency[x][y - 1] & 0x74) == 0 && (objectAdjacency[x + 1][y] & 0x72) == 0 && (objectAdjacency[x + 1][y - 1] & 0x76) == 0 && routeVia[x + 1][y - 1] == 0) {
                routeX[writePtr] = x + 1;
                routeY[writePtr] = y - 1;
                writePtr = (writePtr + 1) % size;
                routeVia[x + 1][y - 1] = 9;
            }
            if (x > 0 && y < 95 && (objectAdjacency[x][y + 1] & 0x71) == 0 && (objectAdjacency[x - 1][y] & 0x78) == 0 && (objectAdjacency[x - 1][y + 1] & 0x79) == 0 && routeVia[x - 1][y + 1] == 0) {
                routeX[writePtr] = x - 1;
                routeY[writePtr] = y + 1;
                writePtr = (writePtr + 1) % size;
                routeVia[x - 1][y + 1] = 6;
            }
            if (x < 95 && y < 95 && (objectAdjacency[x][y + 1] & 0x71) == 0 && (objectAdjacency[x + 1][y] & 0x72) == 0 && (objectAdjacency[x + 1][y + 1] & 0x73) == 0 && routeVia[x + 1][y + 1] == 0) {
                routeX[writePtr] = x + 1;
                routeY[writePtr] = y + 1;
                writePtr = (writePtr + 1) % size;
                routeVia[x + 1][y + 1] = 12;
            }
        }
        if (!reached)
            return -1;
        readPtr = 0;
        routeX[readPtr] = x;
        routeY[readPtr++] = y;
        int stride;
        for (int step = stride = routeVia[x][y]; x != startX || y != startY; step = routeVia[x][y]) {
            if (step != stride) {
                stride = step;
                routeX[readPtr] = x;
                routeY[readPtr++] = y;
            }
            if ((step & 2) != 0)
                x++;
            else if ((step & 8) != 0)
                x--;
            if ((step & 1) != 0)
                y++;
            else if ((step & 4) != 0)
                y--;
        }

        return readPtr;
    }

    public void setObjectAdjacency(int x, int y, int dir, int id) {
        if (x < 0 || y < 0 || x >= 95 || y >= 95)
            return;
        if (GameData.wallObjectVisible[id] == 1) {
            if (dir == 0) {
                objectAdjacency[x][y] |= 1;
                if (y > 0)
                    method419(x, y - 1, 4);
            } else if (dir == 1) {
                objectAdjacency[x][y] |= 2;
                if (x > 0)
                    method419(x - 1, y, 8);
            } else if (dir == 2)
                objectAdjacency[x][y] |= 0x10;
            else if (dir == 3)
                objectAdjacency[x][y] |= 0x20;
            method404(x, y, 1, 1);
        }
    }

    public void loadSection(int x, int y, int plane, boolean flag) {
        int l = (x + 24) / 48;
        int i1 = (y + 24) / 48;
        loadSection(l - 1, i1 - 1, plane, 0);
        loadSection(l, i1 - 1, plane, 1);
        loadSection(l - 1, i1, plane, 2);
        loadSection(l, i1, plane, 3);
        setTiles();
        if (parentModel == null)
            parentModel = new GameModel(18688, 18688, true, true, false, false, true);
        if (flag) {
            surface.blackScreen();
            for (int j1 = 0; j1 < 96; j1++) {
                for (int l1 = 0; l1 < 96; l1++)
                    objectAdjacency[j1][l1] = 0;

            }

            GameModel gameModel = parentModel;
            gameModel.clear();
            for (int j2 = 0; j2 < 96; j2++) {
                for (int i3 = 0; i3 < 96; i3++) {
                    int i4 = -getTerrainHeight(j2, i3);
                    if (getTileDecoration(j2, i3, plane) > 0 && GameData.anIntArray98[getTileDecoration(j2, i3, plane) - 1] == 4)
                        i4 = 0;
                    if (getTileDecoration(j2 - 1, i3, plane) > 0 && GameData.anIntArray98[getTileDecoration(j2 - 1, i3, plane) - 1] == 4)
                        i4 = 0;
                    if (getTileDecoration(j2, i3 - 1, plane) > 0 && GameData.anIntArray98[getTileDecoration(j2, i3 - 1, plane) - 1] == 4)
                        i4 = 0;
                    if (getTileDecoration(j2 - 1, i3 - 1, plane) > 0 && GameData.anIntArray98[getTileDecoration(j2 - 1, i3 - 1, plane) - 1] == 4)
                        i4 = 0;
                    int j5 = gameModel.vertexAt(j2 * 128, i4, i3 * 128);
                    int j7 = (int) (Math.random() * 10D) - 5;
                    gameModel.setVertexAmbience(j5, j7);
                }

            }

            for (int j3 = 0; j3 < 95; j3++) {
                for (int j4 = 0; j4 < 95; j4++) {
                    int k5 = method408(j3, j4);
                    int k7 = anIntArray578[k5];
                    int i10 = k7;
                    int k12 = k7;
                    int l14 = 0;
                    if (plane == 1 || plane == 2) {
                        k7 = 0xbc614e;
                        i10 = 0xbc614e;
                        k12 = 0xbc614e;
                    }
                    if (getTileDecoration(j3, j4, plane) > 0) {
                        int l16 = getTileDecoration(j3, j4, plane);
                        int l5 = GameData.anIntArray98[l16 - 1];
                        int i19 = method420(j3, j4, plane);
                        k7 = i10 = GameData.anIntArray97[l16 - 1];
                        if (l5 == 4) {
                            k7 = 1;
                            i10 = 1;
                            if (l16 == 12) {
                                k7 = 31;
                                i10 = 31;
                            }
                        }
                        if (l5 == 5) {
                            if (getWallDiagonal(j3, j4) > 0 && getWallDiagonal(j3, j4) < 24000)
                                if (getTileDecoration(j3 - 1, j4, plane, k12) != 0xbc614e && getTileDecoration(j3, j4 - 1, plane, k12) != 0xbc614e) {
                                    k7 = getTileDecoration(j3 - 1, j4, plane, k12);
                                    l14 = 0;
                                } else if (getTileDecoration(j3 + 1, j4, plane, k12) != 0xbc614e && getTileDecoration(j3, j4 + 1, plane, k12) != 0xbc614e) {
                                    i10 = getTileDecoration(j3 + 1, j4, plane, k12);
                                    l14 = 0;
                                } else if (getTileDecoration(j3 + 1, j4, plane, k12) != 0xbc614e && getTileDecoration(j3, j4 - 1, plane, k12) != 0xbc614e) {
                                    i10 = getTileDecoration(j3 + 1, j4, plane, k12);
                                    l14 = 1;
                                } else if (getTileDecoration(j3 - 1, j4, plane, k12) != 0xbc614e && getTileDecoration(j3, j4 + 1, plane, k12) != 0xbc614e) {
                                    k7 = getTileDecoration(j3 - 1, j4, plane, k12);
                                    l14 = 1;
                                }
                        } else if (l5 != 2 || getWallDiagonal(j3, j4) > 0 && getWallDiagonal(j3, j4) < 24000)
                            if (method420(j3 - 1, j4, plane) != i19 && method420(j3, j4 - 1, plane) != i19) {
                                k7 = k12;
                                l14 = 0;
                            } else if (method420(j3 + 1, j4, plane) != i19 && method420(j3, j4 + 1, plane) != i19) {
                                i10 = k12;
                                l14 = 0;
                            } else if (method420(j3 + 1, j4, plane) != i19 && method420(j3, j4 - 1, plane) != i19) {
                                i10 = k12;
                                l14 = 1;
                            } else if (method420(j3 - 1, j4, plane) != i19 && method420(j3, j4 + 1, plane) != i19) {
                                k7 = k12;
                                l14 = 1;
                            }
                        if (GameData.anIntArray99[l16 - 1] != 0)
                            objectAdjacency[j3][j4] |= 0x40;
                        if (GameData.anIntArray98[l16 - 1] == 2)
                            objectAdjacency[j3][j4] |= 0x80;
                    }
                    method402(j3, j4, l14, k7, i10);
                    int i17 = ((getTerrainHeight(j3 + 1, j4 + 1) - getTerrainHeight(j3 + 1, j4)) + getTerrainHeight(j3, j4 + 1)) - getTerrainHeight(j3, j4);
                    if (k7 != i10 || i17 != 0) {
                        int ai[] = new int[3];
                        int ai7[] = new int[3];
                        if (l14 == 0) {
                            if (k7 != 0xbc614e) {
                                ai[0] = j4 + j3 * 96 + 96;
                                ai[1] = j4 + j3 * 96;
                                ai[2] = j4 + j3 * 96 + 1;
                                int l21 = gameModel.createFace(3, ai, 0xbc614e, k7);
                                anIntArray600[l21] = j3;
                                anIntArray587[l21] = j4;
                                gameModel.faceTag[l21] = 0x30d40 + l21;
                            }
                            if (i10 != 0xbc614e) {
                                ai7[0] = j4 + j3 * 96 + 1;
                                ai7[1] = j4 + j3 * 96 + 96 + 1;
                                ai7[2] = j4 + j3 * 96 + 96;
                                int i22 = gameModel.createFace(3, ai7, 0xbc614e, i10);
                                anIntArray600[i22] = j3;
                                anIntArray587[i22] = j4;
                                gameModel.faceTag[i22] = 0x30d40 + i22;
                            }
                        } else {
                            if (k7 != 0xbc614e) {
                                ai[0] = j4 + j3 * 96 + 1;
                                ai[1] = j4 + j3 * 96 + 96 + 1;
                                ai[2] = j4 + j3 * 96;
                                int j22 = gameModel.createFace(3, ai, 0xbc614e, k7);
                                anIntArray600[j22] = j3;
                                anIntArray587[j22] = j4;
                                gameModel.faceTag[j22] = 0x30d40 + j22;
                            }
                            if (i10 != 0xbc614e) {
                                ai7[0] = j4 + j3 * 96 + 96;
                                ai7[1] = j4 + j3 * 96;
                                ai7[2] = j4 + j3 * 96 + 96 + 1;
                                int k22 = gameModel.createFace(3, ai7, 0xbc614e, i10);
                                anIntArray600[k22] = j3;
                                anIntArray587[k22] = j4;
                                gameModel.faceTag[k22] = 0x30d40 + k22;
                            }
                        }
                    } else if (k7 != 0xbc614e) {
                        int ai1[] = new int[4];
                        ai1[0] = j4 + j3 * 96 + 96;
                        ai1[1] = j4 + j3 * 96;
                        ai1[2] = j4 + j3 * 96 + 1;
                        ai1[3] = j4 + j3 * 96 + 96 + 1;
                        int l19 = gameModel.createFace(4, ai1, 0xbc614e, k7);
                        anIntArray600[l19] = j3;
                        anIntArray587[l19] = j4;
                        gameModel.faceTag[l19] = 0x30d40 + l19;
                    }
                }

            }

            for (int k4 = 1; k4 < 95; k4++) {
                for (int i6 = 1; i6 < 95; i6++)
                    if (getTileDecoration(k4, i6, plane) > 0 && GameData.anIntArray98[getTileDecoration(k4, i6, plane) - 1] == 4) {
                        int l7 = GameData.anIntArray97[getTileDecoration(k4, i6, plane) - 1];
                        int j10 = gameModel.vertexAt(k4 * 128, -getTerrainHeight(k4, i6), i6 * 128);
                        int l12 = gameModel.vertexAt((k4 + 1) * 128, -getTerrainHeight(k4 + 1, i6), i6 * 128);
                        int i15 = gameModel.vertexAt((k4 + 1) * 128, -getTerrainHeight(k4 + 1, i6 + 1), (i6 + 1) * 128);
                        int j17 = gameModel.vertexAt(k4 * 128, -getTerrainHeight(k4, i6 + 1), (i6 + 1) * 128);
                        int ai2[] = {
                                j10, l12, i15, j17
                        };
                        int i20 = gameModel.createFace(4, ai2, l7, 0xbc614e);
                        anIntArray600[i20] = k4;
                        anIntArray587[i20] = i6;
                        gameModel.faceTag[i20] = 0x30d40 + i20;
                        method402(k4, i6, 0, l7, l7);
                    } else if (getTileDecoration(k4, i6, plane) == 0 || GameData.anIntArray98[getTileDecoration(k4, i6, plane) - 1] != 3) {
                        if (getTileDecoration(k4, i6 + 1, plane) > 0 && GameData.anIntArray98[getTileDecoration(k4, i6 + 1, plane) - 1] == 4) {
                            int i8 = GameData.anIntArray97[getTileDecoration(k4, i6 + 1, plane) - 1];
                            int k10 = gameModel.vertexAt(k4 * 128, -getTerrainHeight(k4, i6), i6 * 128);
                            int i13 = gameModel.vertexAt((k4 + 1) * 128, -getTerrainHeight(k4 + 1, i6), i6 * 128);
                            int j15 = gameModel.vertexAt((k4 + 1) * 128, -getTerrainHeight(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int k17 = gameModel.vertexAt(k4 * 128, -getTerrainHeight(k4, i6 + 1), (i6 + 1) * 128);
                            int ai3[] = {
                                    k10, i13, j15, k17
                            };
                            int j20 = gameModel.createFace(4, ai3, i8, 0xbc614e);
                            anIntArray600[j20] = k4;
                            anIntArray587[j20] = i6;
                            gameModel.faceTag[j20] = 0x30d40 + j20;
                            method402(k4, i6, 0, i8, i8);
                        }
                        if (getTileDecoration(k4, i6 - 1, plane) > 0 && GameData.anIntArray98[getTileDecoration(k4, i6 - 1, plane) - 1] == 4) {
                            int j8 = GameData.anIntArray97[getTileDecoration(k4, i6 - 1, plane) - 1];
                            int l10 = gameModel.vertexAt(k4 * 128, -getTerrainHeight(k4, i6), i6 * 128);
                            int j13 = gameModel.vertexAt((k4 + 1) * 128, -getTerrainHeight(k4 + 1, i6), i6 * 128);
                            int k15 = gameModel.vertexAt((k4 + 1) * 128, -getTerrainHeight(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int l17 = gameModel.vertexAt(k4 * 128, -getTerrainHeight(k4, i6 + 1), (i6 + 1) * 128);
                            int ai4[] = {
                                    l10, j13, k15, l17
                            };
                            int k20 = gameModel.createFace(4, ai4, j8, 0xbc614e);
                            anIntArray600[k20] = k4;
                            anIntArray587[k20] = i6;
                            gameModel.faceTag[k20] = 0x30d40 + k20;
                            method402(k4, i6, 0, j8, j8);
                        }
                        if (getTileDecoration(k4 + 1, i6, plane) > 0 && GameData.anIntArray98[getTileDecoration(k4 + 1, i6, plane) - 1] == 4) {
                            int k8 = GameData.anIntArray97[getTileDecoration(k4 + 1, i6, plane) - 1];
                            int i11 = gameModel.vertexAt(k4 * 128, -getTerrainHeight(k4, i6), i6 * 128);
                            int k13 = gameModel.vertexAt((k4 + 1) * 128, -getTerrainHeight(k4 + 1, i6), i6 * 128);
                            int l15 = gameModel.vertexAt((k4 + 1) * 128, -getTerrainHeight(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int i18 = gameModel.vertexAt(k4 * 128, -getTerrainHeight(k4, i6 + 1), (i6 + 1) * 128);
                            int ai5[] = {
                                    i11, k13, l15, i18
                            };
                            int l20 = gameModel.createFace(4, ai5, k8, 0xbc614e);
                            anIntArray600[l20] = k4;
                            anIntArray587[l20] = i6;
                            gameModel.faceTag[l20] = 0x30d40 + l20;
                            method402(k4, i6, 0, k8, k8);
                        }
                        if (getTileDecoration(k4 - 1, i6, plane) > 0 && GameData.anIntArray98[getTileDecoration(k4 - 1, i6, plane) - 1] == 4) {
                            int l8 = GameData.anIntArray97[getTileDecoration(k4 - 1, i6, plane) - 1];
                            int j11 = gameModel.vertexAt(k4 * 128, -getTerrainHeight(k4, i6), i6 * 128);
                            int l13 = gameModel.vertexAt((k4 + 1) * 128, -getTerrainHeight(k4 + 1, i6), i6 * 128);
                            int i16 = gameModel.vertexAt((k4 + 1) * 128, -getTerrainHeight(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int j18 = gameModel.vertexAt(k4 * 128, -getTerrainHeight(k4, i6 + 1), (i6 + 1) * 128);
                            int ai6[] = {
                                    j11, l13, i16, j18
                            };
                            int i21 = gameModel.createFace(4, ai6, l8, 0xbc614e);
                            anIntArray600[i21] = k4;
                            anIntArray587[i21] = i6;
                            gameModel.faceTag[i21] = 0x30d40 + i21;
                            method402(k4, i6, 0, l8, l8);
                        }
                    }

            }

            gameModel.setLight(true, 40, 48, -50, -10, -50);
            aGameModelArray599 = parentModel.split(0, 0, 1536, 1536, 8, 64, 233, false);
            for (int j6 = 0; j6 < 64; j6++)
                scene.addModel(aGameModelArray599[j6]);

            for (int X = 0; X < 96; X++) {
                for (int Y = 0; Y < 96; Y++)
                    terrainHeightLocal[X][Y] = getTerrainHeight(X, Y);

            }

        }
        parentModel.clear();
        int k1 = 0x606060;
        for (int i2 = 0; i2 < 95; i2++) {
            for (int k2 = 0; k2 < 95; k2++) {
                int k3 = getWallEastwest(i2, k2);
                if (k3 > 0 && (GameData.wallObjectInvisible[k3 - 1] == 0 || aBoolean592)) {
                    method422(parentModel, k3 - 1, i2, k2, i2 + 1, k2);
                    if (flag && GameData.wallObjectVisible[k3 - 1] != 0) {
                        objectAdjacency[i2][k2] |= 1;
                        if (k2 > 0)
                            method419(i2, k2 - 1, 4);
                    }
                    if (flag)
                        surface.drawLineHoriz(i2 * 3, k2 * 3, 3, k1);
                }
                k3 = getWallNorthsouth(i2, k2);
                if (k3 > 0 && (GameData.wallObjectInvisible[k3 - 1] == 0 || aBoolean592)) {
                    method422(parentModel, k3 - 1, i2, k2, i2, k2 + 1);
                    if (flag && GameData.wallObjectVisible[k3 - 1] != 0) {
                        objectAdjacency[i2][k2] |= 2;
                        if (i2 > 0)
                            method419(i2 - 1, k2, 8);
                    }
                    if (flag)
                        surface.drawLineVert(i2 * 3, k2 * 3, 3, k1);
                }
                k3 = getWallDiagonal(i2, k2);
                if (k3 > 0 && k3 < 12000 && (GameData.wallObjectInvisible[k3 - 1] == 0 || aBoolean592)) {
                    method422(parentModel, k3 - 1, i2, k2, i2 + 1, k2 + 1);
                    if (flag && GameData.wallObjectVisible[k3 - 1] != 0)
                        objectAdjacency[i2][k2] |= 0x20;
                    if (flag) {
                        surface.setPixel(i2 * 3, k2 * 3, k1);
                        surface.setPixel(i2 * 3 + 1, k2 * 3 + 1, k1);
                        surface.setPixel(i2 * 3 + 2, k2 * 3 + 2, k1);
                    }
                }
                if (k3 > 12000 && k3 < 24000 && (GameData.wallObjectInvisible[k3 - 12001] == 0 || aBoolean592)) {
                    method422(parentModel, k3 - 12001, i2 + 1, k2, i2, k2 + 1);
                    if (flag && GameData.wallObjectVisible[k3 - 12001] != 0)
                        objectAdjacency[i2][k2] |= 0x10;
                    if (flag) {
                        surface.setPixel(i2 * 3 + 2, k2 * 3, k1);
                        surface.setPixel(i2 * 3 + 1, k2 * 3 + 1, k1);
                        surface.setPixel(i2 * 3, k2 * 3 + 2, k1);
                    }
                }
            }

        }

        if (flag)
            surface.drawSprite(baseMediaSprite - 1, 0, 0, 285, 285);
        parentModel.setLight(false, 60, 24, -50, -10, -50);
        aGameModelArrayArray577[plane] = parentModel.split(0, 0, 1536, 1536, 8, 64, 338, true);
        for (int l2 = 0; l2 < 64; l2++)
            scene.addModel(aGameModelArrayArray577[plane][l2]);

        for (int l3 = 0; l3 < 95; l3++) {
            for (int l4 = 0; l4 < 95; l4++) {
                int k6 = getWallEastwest(l3, l4);
                if (k6 > 0)
                    method428(k6 - 1, l3, l4, l3 + 1, l4);
                k6 = getWallNorthsouth(l3, l4);
                if (k6 > 0)
                    method428(k6 - 1, l3, l4, l3, l4 + 1);
                k6 = getWallDiagonal(l3, l4);
                if (k6 > 0 && k6 < 12000)
                    method428(k6 - 1, l3, l4, l3 + 1, l4 + 1);
                if (k6 > 12000 && k6 < 24000)
                    method428(k6 - 12001, l3 + 1, l4, l3, l4 + 1);
            }

        }

        for (int i5 = 1; i5 < 95; i5++) {
            for (int l6 = 1; l6 < 95; l6++) {
                int j9 = getWallRoof(i5, l6);
                if (j9 > 0) {
                    int l11 = i5;
                    int i14 = l6;
                    int j16 = i5 + 1;
                    int k18 = l6;
                    int j19 = i5 + 1;
                    int j21 = l6 + 1;
                    int l22 = i5;
                    int j23 = l6 + 1;
                    int l23 = 0;
                    int j24 = terrainHeightLocal[l11][i14];
                    int l24 = terrainHeightLocal[j16][k18];
                    int j25 = terrainHeightLocal[j19][j21];
                    int l25 = terrainHeightLocal[l22][j23];
                    if (j24 > 0x13880)
                        j24 -= 0x13880;
                    if (l24 > 0x13880)
                        l24 -= 0x13880;
                    if (j25 > 0x13880)
                        j25 -= 0x13880;
                    if (l25 > 0x13880)
                        l25 -= 0x13880;
                    if (j24 > l23)
                        l23 = j24;
                    if (l24 > l23)
                        l23 = l24;
                    if (j25 > l23)
                        l23 = j25;
                    if (l25 > l23)
                        l23 = l25;
                    if (l23 >= 0x13880)
                        l23 -= 0x13880;
                    if (j24 < 0x13880)
                        terrainHeightLocal[l11][i14] = l23;
                    else
                        terrainHeightLocal[l11][i14] -= 0x13880;
                    if (l24 < 0x13880)
                        terrainHeightLocal[j16][k18] = l23;
                    else
                        terrainHeightLocal[j16][k18] -= 0x13880;
                    if (j25 < 0x13880)
                        terrainHeightLocal[j19][j21] = l23;
                    else
                        terrainHeightLocal[j19][j21] -= 0x13880;
                    if (l25 < 0x13880)
                        terrainHeightLocal[l22][j23] = l23;
                    else
                        terrainHeightLocal[l22][j23] -= 0x13880;
                }
            }

        }

        parentModel.clear();
        for (int i7 = 1; i7 < 95; i7++) {
            for (int k9 = 1; k9 < 95; k9++) {
                int i12 = getWallRoof(i7, k9);
                if (i12 > 0) {
                    int j14 = i7;
                    int k16 = k9;
                    int l18 = i7 + 1;
                    int k19 = k9;
                    int k21 = i7 + 1;
                    int i23 = k9 + 1;
                    int k23 = i7;
                    int i24 = k9 + 1;
                    int k24 = i7 * 128;
                    int i25 = k9 * 128;
                    int k25 = k24 + 128;
                    int i26 = i25 + 128;
                    int j26 = k24;
                    int k26 = i25;
                    int l26 = k25;
                    int i27 = i26;
                    int j27 = terrainHeightLocal[j14][k16];
                    int k27 = terrainHeightLocal[l18][k19];
                    int l27 = terrainHeightLocal[k21][i23];
                    int i28 = terrainHeightLocal[k23][i24];
                    int j28 = GameData.anIntArray101[i12 - 1];
                    if (method406(j14, k16) && j27 < 0x13880) {
                        j27 += j28 + 0x13880;
                        terrainHeightLocal[j14][k16] = j27;
                    }
                    if (method406(l18, k19) && k27 < 0x13880) {
                        k27 += j28 + 0x13880;
                        terrainHeightLocal[l18][k19] = k27;
                    }
                    if (method406(k21, i23) && l27 < 0x13880) {
                        l27 += j28 + 0x13880;
                        terrainHeightLocal[k21][i23] = l27;
                    }
                    if (method406(k23, i24) && i28 < 0x13880) {
                        i28 += j28 + 0x13880;
                        terrainHeightLocal[k23][i24] = i28;
                    }
                    if (j27 >= 0x13880)
                        j27 -= 0x13880;
                    if (k27 >= 0x13880)
                        k27 -= 0x13880;
                    if (l27 >= 0x13880)
                        l27 -= 0x13880;
                    if (i28 >= 0x13880)
                        i28 -= 0x13880;
                    byte byte0 = 16;
                    if (!method427(j14 - 1, k16))
                        k24 -= byte0;
                    if (!method427(j14 + 1, k16))
                        k24 += byte0;
                    if (!method427(j14, k16 - 1))
                        i25 -= byte0;
                    if (!method427(j14, k16 + 1))
                        i25 += byte0;
                    if (!method427(l18 - 1, k19))
                        k25 -= byte0;
                    if (!method427(l18 + 1, k19))
                        k25 += byte0;
                    if (!method427(l18, k19 - 1))
                        k26 -= byte0;
                    if (!method427(l18, k19 + 1))
                        k26 += byte0;
                    if (!method427(k21 - 1, i23))
                        l26 -= byte0;
                    if (!method427(k21 + 1, i23))
                        l26 += byte0;
                    if (!method427(k21, i23 - 1))
                        i26 -= byte0;
                    if (!method427(k21, i23 + 1))
                        i26 += byte0;
                    if (!method427(k23 - 1, i24))
                        j26 -= byte0;
                    if (!method427(k23 + 1, i24))
                        j26 += byte0;
                    if (!method427(k23, i24 - 1))
                        i27 -= byte0;
                    if (!method427(k23, i24 + 1))
                        i27 += byte0;
                    i12 = GameData.anIntArray102[i12 - 1];
                    j27 = -j27;
                    k27 = -k27;
                    l27 = -l27;
                    i28 = -i28;
                    if (getWallDiagonal(i7, k9) > 12000 && getWallDiagonal(i7, k9) < 24000 && getWallRoof(i7 - 1, k9 - 1) == 0) {
                        int ai8[] = new int[3];
                        ai8[0] = parentModel.vertexAt(l26, l27, i26);
                        ai8[1] = parentModel.vertexAt(j26, i28, i27);
                        ai8[2] = parentModel.vertexAt(k25, k27, k26);
                        parentModel.createFace(3, ai8, i12, 0xbc614e);
                    } else if (getWallDiagonal(i7, k9) > 12000 && getWallDiagonal(i7, k9) < 24000 && getWallRoof(i7 + 1, k9 + 1) == 0) {
                        int ai9[] = new int[3];
                        ai9[0] = parentModel.vertexAt(k24, j27, i25);
                        ai9[1] = parentModel.vertexAt(k25, k27, k26);
                        ai9[2] = parentModel.vertexAt(j26, i28, i27);
                        parentModel.createFace(3, ai9, i12, 0xbc614e);
                    } else if (getWallDiagonal(i7, k9) > 0 && getWallDiagonal(i7, k9) < 12000 && getWallRoof(i7 + 1, k9 - 1) == 0) {
                        int ai10[] = new int[3];
                        ai10[0] = parentModel.vertexAt(j26, i28, i27);
                        ai10[1] = parentModel.vertexAt(k24, j27, i25);
                        ai10[2] = parentModel.vertexAt(l26, l27, i26);
                        parentModel.createFace(3, ai10, i12, 0xbc614e);
                    } else if (getWallDiagonal(i7, k9) > 0 && getWallDiagonal(i7, k9) < 12000 && getWallRoof(i7 - 1, k9 + 1) == 0) {
                        int ai11[] = new int[3];
                        ai11[0] = parentModel.vertexAt(k25, k27, k26);
                        ai11[1] = parentModel.vertexAt(l26, l27, i26);
                        ai11[2] = parentModel.vertexAt(k24, j27, i25);
                        parentModel.createFace(3, ai11, i12, 0xbc614e);
                    } else if (j27 == k27 && l27 == i28) {
                        int ai12[] = new int[4];
                        ai12[0] = parentModel.vertexAt(k24, j27, i25);
                        ai12[1] = parentModel.vertexAt(k25, k27, k26);
                        ai12[2] = parentModel.vertexAt(l26, l27, i26);
                        ai12[3] = parentModel.vertexAt(j26, i28, i27);
                        parentModel.createFace(4, ai12, i12, 0xbc614e);
                    } else if (j27 == i28 && k27 == l27) {
                        int ai13[] = new int[4];
                        ai13[0] = parentModel.vertexAt(j26, i28, i27);
                        ai13[1] = parentModel.vertexAt(k24, j27, i25);
                        ai13[2] = parentModel.vertexAt(k25, k27, k26);
                        ai13[3] = parentModel.vertexAt(l26, l27, i26);
                        parentModel.createFace(4, ai13, i12, 0xbc614e);
                    } else {
                        boolean flag1 = true;
                        if (getWallRoof(i7 - 1, k9 - 1) > 0)
                            flag1 = false;
                        if (getWallRoof(i7 + 1, k9 + 1) > 0)
                            flag1 = false;
                        if (!flag1) {
                            int ai14[] = new int[3];
                            ai14[0] = parentModel.vertexAt(k25, k27, k26);
                            ai14[1] = parentModel.vertexAt(l26, l27, i26);
                            ai14[2] = parentModel.vertexAt(k24, j27, i25);
                            parentModel.createFace(3, ai14, i12, 0xbc614e);
                            int ai16[] = new int[3];
                            ai16[0] = parentModel.vertexAt(j26, i28, i27);
                            ai16[1] = parentModel.vertexAt(k24, j27, i25);
                            ai16[2] = parentModel.vertexAt(l26, l27, i26);
                            parentModel.createFace(3, ai16, i12, 0xbc614e);
                        } else {
                            int ai15[] = new int[3];
                            ai15[0] = parentModel.vertexAt(k24, j27, i25);
                            ai15[1] = parentModel.vertexAt(k25, k27, k26);
                            ai15[2] = parentModel.vertexAt(j26, i28, i27);
                            parentModel.createFace(3, ai15, i12, 0xbc614e);
                            int ai17[] = new int[3];
                            ai17[0] = parentModel.vertexAt(l26, l27, i26);
                            ai17[1] = parentModel.vertexAt(j26, i28, i27);
                            ai17[2] = parentModel.vertexAt(k25, k27, k26);
                            parentModel.createFace(3, ai17, i12, 0xbc614e);
                        }
                    }
                }
            }

        }

        parentModel.setLight(true, 50, 50, -50, -10, -50);
        aGameModelArrayArray583[plane] = parentModel.split(0, 0, 1536, 1536, 8, 64, 169, true);
        for (int l9 = 0; l9 < 64; l9++)
            scene.addModel(aGameModelArrayArray583[plane][l9]);

        if (aGameModelArrayArray583[plane][0] == null)
            throw new RuntimeException("null roof!");
        for (int j12 = 0; j12 < 96; j12++) {
            for (int k14 = 0; k14 < 96; k14++)
                if (terrainHeightLocal[j12][k14] >= 0x13880)
                    terrainHeightLocal[j12][k14] -= 0x13880;

        }

    }

    public void method419(int i, int j, int k) {
        objectAdjacency[i][j] |= k;
    }

    public int method420(int i, int j, int k) {
        int l = getTileDecoration(i, j, k);
        if (l == 0)
            return -1;
        int i1 = GameData.anIntArray98[l - 1];
        return i1 != 2 ? 0 : 1;
    }

    public void addModels(GameModel aclass5[]) {
        for (int i = 0; i < 94; i++) {
            for (int j = 0; j < 94; j++)
                if (getWallDiagonal(i, j) > 48000 && getWallDiagonal(i, j) < 60000) {
                    int k = getWallDiagonal(i, j) - 48001;
                    int l = getTileDirection(i, j);
                    int i1;
                    int j1;
                    if (l == 0 || l == 4) {
                        i1 = GameData.objectWidth[k];
                        j1 = GameData.objectHeight[k];
                    } else {
                        j1 = GameData.objectWidth[k];
                        i1 = GameData.objectHeight[k];
                    }
                    method400(i, j, k);
                    GameModel gameModel = aclass5[GameData.objectModelIndex[k]].copy(false, true, false, false);
                    int k1 = ((i + i + i1) * 128) / 2;
                    int i2 = ((j + j + j1) * 128) / 2;
                    gameModel.translate(k1, -getElevation(k1, i2), i2);
                    gameModel.orient(0, getTileDirection(i, j) * 32, 0);
                    scene.addModel(gameModel);
                    gameModel.setLight(48, 48, -50, -10, -50);
                    if (i1 > 1 || j1 > 1) {
                        for (int k2 = i; k2 < i + i1; k2++) {
                            for (int l2 = j; l2 < j + j1; l2++)
                                if ((k2 > i || l2 > j) && getWallDiagonal(k2, l2) - 48001 == k) {
                                    int l1 = k2;
                                    int j2 = l2;
                                    byte byte0 = 0;
                                    if (l1 >= 48 && j2 < 48) {
                                        byte0 = 1;
                                        l1 -= 48;
                                    } else if (l1 < 48 && j2 >= 48) {
                                        byte0 = 2;
                                        j2 -= 48;
                                    } else if (l1 >= 48 && j2 >= 48) {
                                        byte0 = 3;
                                        l1 -= 48;
                                        j2 -= 48;
                                    }
                                    wallsDiagonal[byte0][l1 * 48 + j2] = 0;
                                }

                        }

                    }
                }

        }

    }

    public void method422(GameModel gameModel, int i, int j, int k, int l, int i1) {
        method425(j, k, 40);
        method425(l, i1, 40);
        int j1 = GameData.wallObjectHeight[i];
        int k1 = GameData.wallObjectSomething2[i];
        int l1 = GameData.wallObjectTexture[i];
        int i2 = j * 128;
        int j2 = k * 128;
        int k2 = l * 128;
        int l2 = i1 * 128;
        int i3 = gameModel.vertexAt(i2, -terrainHeightLocal[j][k], j2);
        int j3 = gameModel.vertexAt(i2, -terrainHeightLocal[j][k] - j1, j2);
        int k3 = gameModel.vertexAt(k2, -terrainHeightLocal[l][i1] - j1, l2);
        int l3 = gameModel.vertexAt(k2, -terrainHeightLocal[l][i1], l2);
        int ai[] = {
                i3, j3, k3, l3
        };
        int i4 = gameModel.createFace(4, ai, k1, l1);
        if (GameData.wallObjectInvisible[i] == 5) {
            gameModel.faceTag[i4] = 30000 + i;
            return;
        } else {
            gameModel.faceTag[i4] = 0;
            return;
        }
    }

    public int getTerrainHeight(int x, int y) {
        if (x < 0 || x >= 96 || y < 0 || y >= 96)
            return 0;
        byte d = 0;
        if (x >= 48 && y < 48) {
            d = 1;
            x -= 48;
        } else if (x < 48 && y >= 48) {
            d = 2;
            y -= 48;
        } else if (x >= 48 && y >= 48) {
            d = 3;
            x -= 48;
            y -= 48;
        }
        return (terrainHeight[d][x * 48 + y] & 0xff) * 3;
    }

    public void loadSection(int x, int y, int plane) {
        reset();
        int l = (x + 24) / 48;
        int i1 = (y + 24) / 48;
        loadSection(x, y, plane, true);
        if (plane == 0) {
            loadSection(x, y, 1, false);
            loadSection(x, y, 2, false);
            loadSection(l - 1, i1 - 1, plane, 0);
            loadSection(l, i1 - 1, plane, 1);
            loadSection(l - 1, i1, plane, 2);
            loadSection(l, i1, plane, 3);
            setTiles();
        }
    }

    public void method425(int i, int j, int k) {
        int l = i / 12;
        int i1 = j / 12;
        int j1 = (i - 1) / 12;
        int k1 = (j - 1) / 12;
        method396(l, i1, i, j, k);
        if (l != j1)
            method396(j1, i1, i, j, k);
        if (i1 != k1)
            method396(l, k1, i, j, k);
        if (l != j1 && i1 != k1)
            method396(j1, k1, i, j, k);
    }

    public World(Scene scene, Surface surface) {
        worldInitialised = true;
        objectAdjacency = new int[96][96];
        tileDirection = new byte[4][2304];
        aGameModelArrayArray577 = new GameModel[4][64];
        anIntArray578 = new int[256];
        wallsNorthsouth = new byte[4][2304];
        wallsRoof = new byte[4][2304];
        terrainHeight = new byte[4][2304];
        aGameModelArrayArray583 = new GameModel[4][64];
        terrainColour = new byte[4][2304];
        anIntArray587 = new int[18432];
        tileDecoration = new byte[4][2304];
        routeVia = new int[96][96];
        wallsDiagonal = new int[4][2304];
        wallsEastwest = new byte[4][2304];
        aBoolean592 = false;
        playerAlive = false;
        terrainHeightLocal = new int[96][96];
        aGameModelArray599 = new GameModel[64];
        anIntArray600 = new int[18432];
        baseMediaSprite = 750;
        this.scene = scene;
        this.surface = surface;
        for (int i = 0; i < 64; i++)
            anIntArray578[i] = Scene.method305(255 - i * 4, 255 - (int) ((double) i * 1.75D), 255 - i * 4);

        for (int j = 0; j < 64; j++)
            anIntArray578[j + 64] = Scene.method305(j * 3, 144, 0);

        for (int k = 0; k < 64; k++)
            anIntArray578[k + 128] = Scene.method305(192 - (int) ((double) k * 1.5D), 144 - (int) ((double) k * 1.5D), 0);

        for (int l = 0; l < 64; l++)
            anIntArray578[l + 192] = Scene.method305(96 - (int) ((double) l * 1.5D), 48 + (int) ((double) l * 1.5D), 0);

    }

    public void removeObject(int x, int y, int id) {
        if (x < 0 || y < 0 || x >= 95 || y >= 95)
            return;
        if (GameData.objectType[id] == 1 || GameData.objectType[id] == 2) {
            int l = getTileDirection(x, y);
            int i1;
            int j1;
            if (l == 0 || l == 4) {
                i1 = GameData.objectWidth[id];
                j1 = GameData.objectHeight[id];
            } else {
                j1 = GameData.objectWidth[id];
                i1 = GameData.objectHeight[id];
            }
            for (int k1 = x; k1 < x + i1; k1++) {
                for (int l1 = y; l1 < y + j1; l1++)
                    if (GameData.objectType[id] == 1)
                        objectAdjacency[k1][l1] &= 0xffbf;
                    else if (l == 0) {
                        objectAdjacency[k1][l1] &= 0xfffd;
                        if (k1 > 0)
                            method407(k1 - 1, l1, 8);
                    } else if (l == 2) {
                        objectAdjacency[k1][l1] &= 0xfffb;
                        if (l1 < 95)
                            method407(k1, l1 + 1, 1);
                    } else if (l == 4) {
                        objectAdjacency[k1][l1] &= 0xfff7;
                        if (k1 < 95)
                            method407(k1 + 1, l1, 2);
                    } else if (l == 6) {
                        objectAdjacency[k1][l1] &= 0xfffe;
                        if (l1 > 0)
                            method407(k1, l1 - 1, 4);
                    }

            }

            method404(x, y, i1, j1);
        }
    }

    public boolean method427(int i, int j) {
        return getWallRoof(i, j) > 0 || getWallRoof(i - 1, j) > 0 || getWallRoof(i - 1, j - 1) > 0 || getWallRoof(i, j - 1) > 0;
    }

    public void method428(int i, int j, int k, int l, int i1) {
        int j1 = GameData.wallObjectHeight[i];
        if (terrainHeightLocal[j][k] < 0x13880)
            terrainHeightLocal[j][k] += 0x13880 + j1;
        if (terrainHeightLocal[l][i1] < 0x13880)
            terrainHeightLocal[l][i1] += 0x13880 + j1;
    }

    final int anInt572 = 96;
    final int anInt573 = 96;
    boolean worldInitialised;
    int objectAdjacency[][];
    byte tileDirection[][];
    GameModel aGameModelArrayArray577[][];
    int anIntArray578[];
    byte wallsNorthsouth[][];
    GameModel parentModel;
    byte wallsRoof[][];
    byte terrainHeight[][];
    GameModel aGameModelArrayArray583[][];
    final int anInt584 = 0xbc614e;
    final int anInt585 = 128;
    byte terrainColour[][];
    int anIntArray587[];
    byte tileDecoration[][];
    int routeVia[][];
    int wallsDiagonal[][];
    byte wallsEastwest[][];
    boolean aBoolean592;
    boolean playerAlive;
    int terrainHeightLocal[][];
    byte landscapePack[];
    byte mapPack[];
    Surface surface;
    Scene scene;
    GameModel aGameModelArray599[];
    int anIntArray600[];
    byte memberLandscapePack[];
    byte memberMapPack[];
    int baseMediaSprite;
}
